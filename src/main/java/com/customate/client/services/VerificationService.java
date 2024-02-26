package com.customate.client.services;

import com.customate.client.CustomateClient;
import com.customate.client.exceptions.ApiException;
import com.customate.client.models.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.UUID;

/**
 * Services for verifications (without a profile).
 *
 * Date: 25-Oct-23
 * Time: 3:04 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class VerificationService {

    /**
     * Gets all verifications for the client.
     *
     * @return VerificationPage  A page of verifications.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static VerificationPage getAll() throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("verifications");
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, VerificationPage.class);
    }

    /**
     * Gets a page of verifications.
     *
     * @param pageNum  The page number (the first page is page 1).
     * @param pageSize  The page size.
     * @return VerificationPage  A page of verifications.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static VerificationPage getPage(int pageNum, int pageSize)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("verifications?page[number]=" + pageNum + "&page[size]=" + pageSize);
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, VerificationPage.class);
    }

    /**
     * Gets a verification.
     *
     * @param id  ID of the verification.
     * @return Verification  A verification object.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static Verification get(UUID id) throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("verifications/" + id);
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, Verification.class);
    }

    /**
     * Verifies a person without a profile - checks the name, gender, date of birth, address, passport, driving licence, identity card, tax ID number.
     *
     * @param verificationNoProfileRequest  The verification request.
     * @return VerificationResponse  The verification response.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static VerificationNoProfileResponse verifyNoProfile(VerificationNoProfileRequest verificationNoProfileRequest)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        String url = "verifications";
        HttpResponse<String> response = CustomateClient.post(url, verificationNoProfileRequest.asJson());
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, VerificationNoProfileResponse.class);
    }

    /**
     * Verifies a person without a profile - politically-exposed persons and sanctions only.
     * Checks the name, date of birth, address, passport.
     *
     * @param verificationPepSanctionsRequest  The verification request.
     * @return VerificationResponse  The verification response.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static VerificationNoProfileResponse verifyPepSanctionsNoProfile(VerificationPepSanctionsRequest verificationPepSanctionsRequest)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        String url = "verifications_politically_exposed_persons_and_sanctions_only";
        HttpResponse<String> response = CustomateClient.post(url, verificationPepSanctionsRequest.asJson());
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, VerificationNoProfileResponse.class);
    }

}
