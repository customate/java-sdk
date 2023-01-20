package com.customate.client.services;

import com.customate.client.CustomateClient;
import com.customate.client.exceptions.ApiException;
import com.customate.client.models.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.customate.client.models.OpenBankingMandate;
import com.customate.client.models.OpenBankingMandatePage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.UUID;

/**
 * Services for open banking mandates.
 *
 * Date: 18-Jan-23
 * Time: 2:41 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class OpenBankingMandateService {

    /**
     * Gets open banking mandate providers. GB and GBP only.
     *
     * @return OpenBankingMandateProviderPage  The list of mandate providers.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static OpenBankingMandateProviderPage getOpenBankingMandateProviders()
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("open_banking_mandate_providers");
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, OpenBankingMandateProviderPage.class);
    }

    /**
     * Creates an open banking mandate (the JSON format is different when creating and getting mandates).
     *
     * @param profileId  Profile ID.
     * @param openBankingMandateCreate  The open banking mandate create.
     * @return OpenBankingMandateResponse  The open banking mandate response.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static OpenBankingMandateResponse createOpenBankingMandate(UUID profileId, OpenBankingMandateCreate openBankingMandateCreate)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response =
                CustomateClient.post("profiles/" + profileId + "/open_banking_to_wallet_mandates",
                                     openBankingMandateCreate.asJson());
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, OpenBankingMandateResponse.class);
    }

    /**
     * Gets all open banking mandates for a profile.
     *
     * @param profileId  Profile ID.
     * @return OpenBankingMandatePage  A page of open banking mandates.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static OpenBankingMandatePage getAll(UUID profileId) throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("profiles/" + profileId + "/open_banking_to_wallet_mandates");
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, OpenBankingMandatePage.class);
    }

    /**
     * Gets a page of open banking mandates for a profile.
     *
     * @param profileId  Profile ID.
     * @param pageNum  The page number (the first page is page 1).
     * @param pageSize  The page size.
     * @return PaymentPage  A page of open banking mandates.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static OpenBankingMandatePage getPage(UUID profileId, int pageNum, int pageSize)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("profiles/" + profileId + "/open_banking_to_wallet_mandates?page[number]=" + pageNum + "&page[size]=" + pageSize);
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, OpenBankingMandatePage.class);
    }

    /**
     * Gets an open banking mandate for a profile.
     *
     * @param profileId  Profile ID.
     * @param mandateId  Mandate ID.
     * @return OpenBankingMandate  The mandate.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static OpenBankingMandate get(UUID profileId, UUID mandateId) throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("profiles/" + profileId + "/open_banking_to_wallet_mandates/" + mandateId);
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, OpenBankingMandate.class);
    }

    /**
     * Deletes an open banking mandate.
     *
     * @param profileId  Profile ID.
     * @param mandateId  Mandate ID.
     * @return int  Status code (204 expected).
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static int delete(UUID profileId, UUID mandateId)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.delete("profiles/" + profileId + "/open_banking_to_wallet_mandates/" + mandateId);
        return response.statusCode();
    }

}
