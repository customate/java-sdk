package com.customate.client.services;

import com.customate.client.CustomateClient;
import com.customate.client.exceptions.ApiException;
import com.customate.client.models.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;

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
