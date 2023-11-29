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
     * @param url  URL, e.g. "profiles".
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
     * @param url  URL, e.g. "profiles".
     * @param bodyContent  The content of the body, as stringified JSON.
     * @return HttpResponse<String>  The HTTP response.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static HttpResponse<String> post(String url, String bodyContent)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        String contentHash = contentHash(bodyContent); // e.g. "41859c831385ac1a76136a7411a7d1c4db8d89da"
        URI uri = new URI(getUrl(url)); // e.g. https://sandbox-api.gocustomate.com/v1/profiles
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
     * @param url  URL, e.g. "profiles/92ac69be-8402-4dae-8d05-48fc30d661de".
     * @param bodyContent  The content of the body, as stringified JSON.
     * @return HttpResponse<String>  The HTTP response.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static HttpResponse<String> put(String url, String bodyContent)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        String contentHash = contentHash(bodyContent); // e.g. "b00c131f698a290b8b448ecfb8dcb4b7f120a7eb"
        URI uri = new URI(getUrl(url)); // e.g. https://sandbox-api.gocustomate.com/v1/profiles/92ac69be-8402-4dae-8d05-48fc30d661de"
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
     * @param url  URL, e.g. "profiles/92ac69be-8402-4dae-8d05-48fc30d661de".
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
     * @param url  URL, e.g. "profiles".
     * @return String  The URL, e.g. "https://sandbox-api.gocustomate.com/v1/profiles".
     */
    private static String getUrl(String url) {
        return baseUrl + "/" + version +  "/" + url;
    }

    /**
     * Hashes the body content using the SHA-1 algorithm.
     *
     * @param bodyContent  The content, as stringified JSON, to be hashed.
     * @return String  The hashed content, e.g. "41859c831385ac1a76136a7411a7d1c4db8d89da".
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
     * @param uri  The URI, e.g. "https://sandbox-api.gocustomate.com/v1/profiles".
     * @param method  "GET", "POST", "PUT", or "DELETE".
     * @param requestBuilder  The HTTP request builder.
     * @param contentHash  The hashed content, e.g. "41859c831385ac1a76136a7411a7d1c4db8d89da".
     * @return Optional<HttpResponse<String>>  The HTTP response.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     */
    private static Optional<HttpResponse<String>> sendRequest(URI uri, String method,
            HttpRequest.Builder requestBuilder, String contentHash) throws IOException, InterruptedException {

        // Get a unique ID
        // e.g. "8361eb9d-6a25-4fee-8606-524779550276"
        String UUIDString = getUUIDString();

        // Get the current date
        // e.g. "2023-11-29T17:08:30+0000"
        String dateString = getDate();

        // Headers - string together the hashed content, date and UUID
        // e.g. "paymentservice-contenthash:41859c831385ac1a76136a7411a7d1c4db8d89da\npaymentservice-date:2023-11-29T17:08:30+0000\npaymentservice-nonce:8361eb9d-6a25-4fee-8606-524779550276"
        String headersString = headersToString(contentHash, dateString, UUIDString);

        // Set the content type (empty for GET and DELETE)
        String contentType = method.equals("POST") || method.equals("PUT") ? "application/json" : "";

        // String together the method, URI, content type and headers
        // e.g. "POST\n/v1/profiles\napplication/json\npaymentservice-contenthash:41859c831385ac1a76136a7411a7d1c4db8d89da\npaymentservice-date:2023-11-29T17:08:30+0000\npaymentservice-nonce:8361eb9d-6a25-4fee-8606-524779550276"
        String accessTokenString = accessTokenToString(method, uri.getPath(), contentType, headersString);

        // Create an access token based on the above token string using the API secret
        // e.g. "3BYRAXmNQpqeEd/NMkKdRIjSOOd1tYS3lG/vZm5pUB4="
        Optional<String> accessToken = createToken(apiSecret.getBytes(StandardCharsets.UTF_8),
                                                    accessTokenString.getBytes(StandardCharsets.UTF_8));

        // Create the auth string, based on the API key and access token
        // e.g. "Signature 6eaad275-ff1e-4cc9-a368-d130dbcae12f:3BYRAXmNQpqeEd/NMkKdRIjSOOd1tYS3lG/vZm5pUB4="
        String authorizationString = getAuthString(accessToken.get());

        HttpResponse<String> response = null;
        
        if (accessToken.isPresent()) {
            requestBuilder.header("Authorization", authorizationString);
            requestBuilder.header("paymentservice-date", dateString);
            requestBuilder.header("paymentservice-nonce", UUIDString);

            if (!contentHash.isEmpty()) { // There will be hashed content for POST and PUT (but an empty string for GET and DELETE)
                requestBuilder.header("paymentservice-contenthash", contentHash);
                requestBuilder.header("Content-Type", contentType);
            }

            HttpRequest request = requestBuilder.build();
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        }
        return Optional.ofNullable(response);
    }

    /**
     * Creates a random, unique UUID.
     *
     * @return String  The UUID as a string, e.g. "8361eb9d-6a25-4fee-8606-524779550276".
     */
    private static String getUUIDString() {
        return UUID.randomUUID().toString();
    }

    /**
    * Gets the current datetime as a string.
    *
    * @return String  The current datetime as a string, e.g. "2023-11-29T17:08:30+0000".
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
     * Converts headers to a string (from the hashed content, date and UUID).
     *
     * @param contentHash  The hashed content, e.g. "41859c831385ac1a76136a7411a7d1c4db8d89da".
     * @param paymentServiceDateString  The current datetime, e.g. "2023-11-29T17:08:30+0000".
     * @param paymentServiceNonceString  A unique UUID, e.g. "8361eb9d-6a25-4fee-8606-524779550276".
     * @return String  The headers as a string, e.g. "paymentservice-contenthash:41859c831385ac1a76136a7411a7d1c4db8d89da\npaymentservice-date:2023-11-29T17:08:30+0000\npaymentservice-nonce:8361eb9d-6a25-4fee-8606-524779550276".
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
     * Creates an access token string (combines the method, URI, content type and headers).
     *
     * @param method  The HTTP method, e.g. "POST".
     * @param path  The URI path, e.g. "/v1/profiles".
     * @param contentType  The content type, "application/json" for POST and PUT, else "".
     * @param headers  The headers a string, e.g. "paymentservice-contenthash:41859c831385ac1a76136a7411a7d1c4db8d89da\npaymentservice-date:2023-11-29T17:08:30+0000\npaymentservice-nonce:8361eb9d-6a25-4fee-8606-524779550276".
     * @return String  Access token, e.g. "POST\n/v1/profiles\napplication/json\npaymentservice-contenthash:41859c831385ac1a76136a7411a7d1c4db8d89da\npaymentservice-date:2023-11-29T17:08:30+0000\npaymentservice-nonce:8361eb9d-6a25-4fee-8606-524779550276".
     */
    private static String accessTokenToString(String method, String path, String contentType, String headers) {
        return new StringBuilder(method)
                .append('\n').append(path).append('\n').append(contentType).append('\n').append(headers).toString();
    }

    /**
     * Creates a token, using HmacSHA256, from the API secret and access token.
     *
     * @param secret  The API secret as a byte array.
     * @param message  The access token string as a byte array.
     * @return String  The token, e.g. "3BYRAXmNQpqeEd/NMkKdRIjSOOd1tYS3lG/vZm5pUB4=".
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
     * Creates an authorization string, from the API key and token.
     *
     * @param hashedString  The hashed token, e.g. "3BYRAXmNQpqeEd/NMkKdRIjSOOd1tYS3lG/vZm5pUB4=".
     * @return String  The authorization string, e.g. "Signature 6eaad275-ff1e-4cc9-a368-d130dbcae12f:3BYRAXmNQpqeEd/NMkKdRIjSOOd1tYS3lG/vZm5pUB4=".
     */
    private static String getAuthString(String hashedString) {
        return new StringBuilder("Signature ").append(apiKey).append(":").append(hashedString).toString();
    }

}
