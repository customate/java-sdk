package com.customate.client.services;

import com.customate.client.CustomateClient;
import com.customate.client.exceptions.ApiException;
import com.customate.client.models.Profile;
import com.customate.client.models.ProfilePage;
import com.customate.client.models.VerificationRequest;
import com.customate.client.models.VerificationResponse;
import com.customate.client.utils.JsonHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.UUID;

/**
 * Services for profiles.
 *
 * Date: 08-Feb-21
 * Time: 2:40 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class ProfileService {

    /**
     * Gets a profile.
     *
     * @param id  ID of the profile.
     * @return Profile  The profile.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static Profile get(UUID id) throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("profiles/" + id);
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, Profile.class);
    }

    /**
     * Gets all profiles.
     *
     * @return ProfilePage  A page of profiles.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static ProfilePage getAll() throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("profiles");
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, ProfilePage.class);
    }

    /**
     * Gets a page of profiles.
     *
     * @param pageNum  The page number (the first page is page 1).
     * @param pageSize  The page size.
     * @return ProfilePage  A page of profiles.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static ProfilePage getPage(int pageNum, int pageSize)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("profiles?page[number]=" + pageNum + "&page[size]=" + pageSize);
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, ProfilePage.class);
    }

    /**
     * Creates a profile.
     *
     * @param profile  The profile to create.
     * @return Profile  The profile.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static Profile create(Profile profile) throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.post("profiles", profile.asJson());
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, Profile.class);
    }

    /**
     * Force-verifies a profile - doesn't check the country of birth, mother's maiden name, passport or driving licence.
     *
     * @param id  The ID of the profile to force verify.
     * @return VerificationResponse  The verification response.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static VerificationResponse forceVerify(UUID id) throws URISyntaxException, IOException, InterruptedException, ApiException {
        JsonNode emptyNode = JsonHelper.createEmptyObjectNode();
        String url = "profiles/" + id + "/verification?force_verification=true";
        HttpResponse<String> response = CustomateClient.post(url, emptyNode.toString());
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, VerificationResponse.class);
    }

    /**
     * Verifies a profile - checks the country of birth, mother's maiden name, passport or driving licence.
     *
     * @param id  The ID of the profile to verify.
     * @param verificationRequest  Includes the country of birth, mother's maiden name, passport and driving licence.
     * @return VerificationResponse  The verification response.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static VerificationResponse verify(UUID id, VerificationRequest verificationRequest)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        String url = "profiles/" + id + "/verification?force_verification=false";
        HttpResponse<String> response = CustomateClient.post(url, verificationRequest.asJson());
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, VerificationResponse.class);
    }

    /**
     * Updates a profile.
     *
     * @param profile  The profile to update.
     * @return Profile  The profile.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static Profile update(Profile profile) throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.put("profiles/" + profile.getId(), profile.asJson());
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, Profile.class);
    }

    /**
     * Deletes a profile.
     *
     * @param id  The ID of the profile to delete.
     * @return int  Status code (204 expected).
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static int delete(UUID id) throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.delete("profiles/" + id);
        return response.statusCode();
    }

}
