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
 * Services for payees.
 *
 * Date: 19-Feb-21
 * Time: 3:44 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class PayeeService {

    /**
     * Gets all payees for a profile.
     *
     * @param profileId  Profile ID.
     * @return PayeePage  A page of payees.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static PayeePage getAll(UUID profileId) throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("profiles/" + profileId + "/payees");
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, PayeePage.class);
    }

    /**
     * Gets a page of payees for a profile.
     *
     * @param profileId  Profile ID.
     * @return PayeePage  A page of payees.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static PayeePage getPage(UUID profileId, int pageNum, int pageSize) throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("profiles/" + profileId + "/payees?page[number]=" + pageNum + "&page[size]=" + pageSize);
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, PayeePage.class);
    }

    /**
     * Gets a payee for a profile.
     *
     * @param profileId  Profile ID.
     * @param payeeId  Payee ID.
     * @return Payee  The payee.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static Payee get(UUID profileId, UUID payeeId) throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("profiles/" + profileId + "/payees/" + payeeId);
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, Payee.class);
    }

    /**
     * Creates a payee (the JSON format is different when creating and getting payees).
     *
     * @param profileId  Profile ID.
     * @param payeeCreate  The payee to create.
     * @return Payee  The payee.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static Payee create(UUID profileId, PayeeCreate payeeCreate) throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.post("profiles/" + profileId + "/payees", payeeCreate.asJson());
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, Payee.class);
    }

    /**
     * Updates a payee.
     *
     * @param profileId  Profile ID.
     * @param payeeId  Payee ID.
     * @param payeeUpdate  The payee to update.
     * @return Payee  The payee.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static Payee update(UUID profileId, UUID payeeId, PayeeUpdate payeeUpdate) throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.put("profiles/" + profileId + "/payees/" + payeeId, payeeUpdate.asJson());
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, Payee.class);
    }

    /**
     * Validates a payee.
     *
     * @param profileId  Profile ID.
     * @param payeeId  Payee ID.
     * @param payeeValidate  The payee to validate.
     * @return Payee  The payee.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static Payee validate(UUID profileId, UUID payeeId, PayeeValidate payeeValidate) throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.put("profiles/" + profileId + "/payees/" + payeeId + "/validate_bank_owner",
                payeeValidate.asJson());
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, Payee.class);
    }

    /**
     * Deletes a payee.
     *
     * @param profileId  Profile ID.
     * @param payeeId  Payee ID.
     * @return int  Status code (204 expected).
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static int delete(UUID profileId, UUID payeeId)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.delete("profiles/" + profileId + "/payees/" + payeeId);
        return response.statusCode();
    }

}
