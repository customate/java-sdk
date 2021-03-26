package com.customate.client;

import com.customate.client.exceptions.ApiException;
import com.customate.client.utils.JsonHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * An SDK that uses Customate's public API.
 * 
 * Date: 04-Feb-21
 * Time: 12:59 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class CustomateClient {

    private static String baseUrl;
    private static String version;
    private static String apiKey;
    private static String apiSecret;

    // Get credentials
    static {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties properties = new Properties();
        try (InputStream resourceStream = loader.getResourceAsStream("application.properties")) {
            properties.load(resourceStream);
            baseUrl = (String) properties.get("customate.baseUrl");
            version = (String) properties.get("customate.version");
            apiKey = (String) properties.get("customate.apiKey");
            apiSecret = (String) properties.get("customate.apiSecret");
        } catch (IOException e) {
            System.out.println("Expected application.properties to have entries for customate.baseUrl, customate.version, customate.apiKey and customate.apiSecret");
        }
    }

    private static final HttpClient httpClient = HttpClient.newBuilder().build();

    /**
     * Sends a GET request.
     *
     * @param url  URL.
     * @return HttpResponse<String>  The HTTP response.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static HttpResponse<String> get(String url)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        URI uri = new URI(getUrl(url));
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder().uri(uri).GET();
        Optional<HttpResponse<String>> response = sendRequest(uri, "GET", requestBuilder, "");
        if (response.isPresent()) {
            HttpResponse<String> httpResponse = response.get();
            checkErrors(httpResponse);
            return httpResponse;
        }
        return null;
    }

    /**
     * Sends a POST request.
     *
     * @param url  URL.
     * @param bodyContent  The content of the body to be posted.
     * @return HttpResponse<String>  The HTTP response.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static HttpResponse<String> post(String url, String bodyContent)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        String contentHash = contentHash(bodyContent);
        URI uri = new URI(getUrl(url));
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder().uri(uri)
                .POST(HttpRequest.BodyPublishers.ofString(bodyContent));
        Optional<HttpResponse<String>> response = sendRequest(uri, "POST", requestBuilder, contentHash);
        if (response.isPresent()) {
            HttpResponse<String> httpResponse = response.get();
            checkErrors(httpResponse);
            return httpResponse;
        }
        return null;
    }

    /**
     * Sends a PUT request.
     *
     * @param url  URL.
     * @param bodyContent  The content of the body to be updated.
     * @return HttpResponse<String>  The HTTP response.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static HttpResponse<String> put(String url, String bodyContent)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        String contentHash = contentHash(bodyContent);
        URI uri = new URI(getUrl(url));
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder().uri(uri)
                .PUT(HttpRequest.BodyPublishers.ofString(bodyContent));
        Optional<HttpResponse<String>> response = sendRequest(uri, "PUT", requestBuilder, contentHash);
        if (response.isPresent()) {
            HttpResponse<String> httpResponse = response.get();
            checkErrors(httpResponse);
            return httpResponse;
        }
        return null;
    }

    /**
     * Sends a DELETE request.
     *
     * @param url  URL.
     * @return HttpResponse<String>  The HTTP response.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static HttpResponse<String> delete(String url)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        URI uri = new URI(getUrl(url));
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder().uri(uri).DELETE();
        Optional<HttpResponse<String>> response = sendRequest(uri, "DELETE", requestBuilder, "");
        if (response.isPresent()) {
            HttpResponse<String> httpResponse = response.get();
            checkErrors(httpResponse);
            return httpResponse;
        }
        return null;
    }

    /**
     * Checks if the API returned errors.
     *
     * @param httpResponse  The HTTP response.
     * @throws JsonProcessingException  If there was a problem processing the JSON.
     * @throws ApiException  If the JSON contains the key "errors".
     */
    private static void checkErrors(HttpResponse<String> httpResponse) throws JsonProcessingException, ApiException {
        String responseBody = httpResponse.body();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(responseBody);
        if (JsonHelper.hasField(rootNode, "errors")) {
            throw new ApiException(rootNode.toString());
        }
    }

    /**
     * Gets the complete URL, including the base URL and version.
     *
     * @param url  URL.
     * @return String  The URL.
     */
    private static String getUrl(String url) {
        return baseUrl + "/" + version +  "/" + url;
    }

    /**
     * Hashes the body content using the SHA-1 algorithm.
     *
     * @param bodyContent  The content to be hashed.
     * @return String  The hashed content.
     */
    private static String contentHash(String bodyContent) {
        String contentHash = "";
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(bodyContent.getBytes("UTF-8"));
            byte[] hash = crypt.digest();

            Formatter formatter = new Formatter();
            for (byte b : hash) {
                formatter.format("%02x", b);
            }
            contentHash = formatter.toString();

            formatter.close();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return contentHash;
    }

    /**
     * Sends a request to the API.
     *
     * @param uri  The URI endpoint.
     * @param method  GET, POST, PUT or DELETE.
     * @param requestBuilder  The HTTP request builder.
     * @param contentHash  The hashed content.
     * @return Optional<HttpResponse<String>>  The HTTP response.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     */
    private static Optional<HttpResponse<String>> sendRequest(URI uri, String method,
            HttpRequest.Builder requestBuilder, String contentHash) throws IOException, InterruptedException {
        String UUIDString = getUUIDString();
        String dateString = getDate();
        String headersString = headersToString(contentHash, dateString, UUIDString);
        String contentType = method.equals("POST") || method.equals("PUT") ? "application/json" : "";
        String accessTokenString = accessTokenToString(method, uri.getPath(), contentType, headersString);
        Optional<String> accessToken = createToken(apiSecret.getBytes(StandardCharsets.UTF_8),
                                                    accessTokenString.getBytes(StandardCharsets.UTF_8));
        String authorizationString = getAuthString(accessToken.get());

        HttpResponse<String> response = null;
        
        if (accessToken.isPresent()) {
            requestBuilder.header("Authorization", authorizationString);
            requestBuilder.header("paymentservice-date", dateString);
            requestBuilder.header("paymentservice-nonce", UUIDString);

            if (!contentHash.isEmpty()) {
                requestBuilder.header("paymentservice-contenthash", contentHash);
                requestBuilder.header("Content-Type", contentType);
            }

            HttpRequest request = requestBuilder.build();
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        }
        return Optional.ofNullable(response);
    }

    /**
     * Creates a random, unique UUID (used when sending a request).
     *
     * @return String  The UUID as a string.
     */
    private static String getUUIDString() {
        return UUID.randomUUID().toString();
    }

    /**
    * Gets the current datetime as a string.
    *
    * @return String  The current datetime as a string.
    */
    private static String getDate() {
        TimeZone timeZone = TimeZone.getDefault();
        ZoneId zoneId = timeZone.toZoneId();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");
        
        Instant now = Instant.ofEpochMilli(System.currentTimeMillis());
        String dateTime = now.atZone(zoneId).format(dateTimeFormatter);
        return dateTime;
    }

    /**
     * Converts headers to a string (used to create an access token string when sending a request).
     *
     * @param contentHash  The hashed content.
     * @param paymentServiceDateString  The current datetime.
     * @param paymentServiceNonceString  A unique UUID.
     * @return String  The headers as a string.
     */
    private static String headersToString(String contentHash,
                                          String paymentServiceDateString, String paymentServiceNonceString) {
        Map<String, String> headersMap = new TreeMap<>();
        headersMap.put("paymentservice-contenthash", contentHash);
        headersMap.put("paymentservice-date", paymentServiceDateString);
        headersMap.put("paymentservice-nonce", paymentServiceNonceString);
        StringBuilder headersString = new StringBuilder();
        headersMap.forEach((K, V) -> headersString.append(K).append(":").append(V).append("\n"));
        return headersString.toString().trim();
    }

    /**
     * Creates an access token string (used to create a token when sending a request).
     *
     * @param method  The HTTP method.
     * @param path  The URI path.
     * @param contentType  The content type (application/json for POST and PUT).
     * @param headers  The headers a string.
     * @return String  Access token.
     */
    private static String accessTokenToString(String method, String path, String contentType, String headers) {
        return new StringBuilder(method)
                .append('\n').append(path).append('\n').append(contentType).append('\n').append(headers).toString();
    }

    /**
     * Creates a token using HmacSHA256 (used to create an authorization string when sending a request).
     *
     * @param secret  The API secret as a byte array.
     * @param message  The access token string as a byte array.
     * @return String  The token.
     */
    private static Optional<String> createToken(byte[] secret, byte[] message) {
        String token = null;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(secret, "HmacSHA256");
            mac.init(secretKeySpec);
            byte[] bytes = mac.doFinal(message);
            token = Base64.getEncoder().encodeToString(bytes);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(token);
    }

    /**
     * Creates an authorization string from a token (used as the Authorization header in the request).
     *
     * @param hashedString  The hashed token.
     * @return String  The authorization string.
     */
    private static String getAuthString(String hashedString) {
        return new StringBuilder("Signature ").append(apiKey).append(":").append(hashedString).toString();
    }

}
