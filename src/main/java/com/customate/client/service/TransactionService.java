package com.customate.client.service;

import com.customate.client.CustomateClient;
import com.customate.client.exceptions.ApiException;
import com.customate.client.models.Transaction;
import com.customate.client.models.TransactionPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.UUID;

/**
 * Services for transactions.
 *
 * Date: 15-Feb-21
 * Time: 2:32 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class TransactionService {

    @Autowired
    private static CustomateClient customateClient;

    /**
     * Gets all transactions for a profile.
     *
     * @param profileId  Profile ID.
     * @return TransactionPage  A page of transactions.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static TransactionPage getAll(UUID profileId) throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = customateClient.get("profiles/" + profileId + "/transactions");
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, TransactionPage.class);
    }

    /**
     * Gets a page of transactions for a profile.
     *
     * @param profileId  Profile ID.
     * @param pageNum  The page number (the first page is page 1).
     * @param pageSize  The page size.
     * @return TransactionPage  A page of transactions.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static TransactionPage getPage(UUID profileId, int pageNum, int pageSize)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = customateClient.get("profiles/" + profileId + "/transactions?page[number]=" + pageNum + "&page[size]=" + pageSize);
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, TransactionPage.class);
    }

    /**
     * Gets a transaction for a profile.
     *
     * @param profileId  Profile ID.
     * @param transactionId  Transaction ID.
     * @return Transaction  The transaction.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static Transaction get(UUID profileId, UUID transactionId)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = customateClient.get("profiles/" + profileId + "/transactions/" + transactionId);
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, Transaction.class);
    }
}
