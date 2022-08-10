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
 * Services for P2P currency exchanges.
 *
 * Date: 08-Aug-22
 * Time: 4:02 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class P2PCurrencyExchangeService {

    /**
     * Gets all P2P currency exchanges for a profile.
     *
     * @param profileId  Profile ID.
     * @return P2PCurrencyExchangePage  A page of P2P currency exchanges.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static P2PCurrencyExchangePage getAll(UUID profileId) throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("profiles/" + profileId + "/p2p_currency_exchanges");
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, P2PCurrencyExchangePage.class);
    }

    /**
     * Gets a page of P2P currency exchanges for a profile.
     *
     * @param profileId  Profile ID.
     * @param pageNum  The page number (the first page is page 1).
     * @param pageSize  The page size.
     * @return P2PCurrencyExchangePage  A page of P2P currency exchanges.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static P2PCurrencyExchangePage getPage(UUID profileId, int pageNum, int pageSize)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("profiles/" + profileId + "/p2p_currency_exchanges?page[number]=" + pageNum + "&page[size]=" + pageSize);
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, P2PCurrencyExchangePage.class);
    }

    /**
     * Gets a P2P currency exchange for a profile.
     *
     * @param profileId  Profile ID.
     * @param currencyExchangeId  The P2P currency exchange ID.
     * @return P2PCurrencyExchange  The P2P currency exchange.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static P2PCurrencyExchange get(UUID profileId, UUID currencyExchangeId) throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("profiles/" + profileId + "/p2p_currency_exchanges/" + currencyExchangeId);
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, P2PCurrencyExchange.class);
    }

    /**
     * Creates a P2P currency exchange.
     *
     * @param profileId  Profile ID.
     * @param p2PCurrencyExchangeCreate  The P2PCurrencyExchangeCreate to create.
     * @return P2PCurrencyExchange  The P2P currency exchange.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static P2PCurrencyExchange createP2PCurrencyExchange(UUID profileId, P2PCurrencyExchangeCreate p2PCurrencyExchangeCreate)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response =
                CustomateClient.post("profiles/" + profileId + "/p2p_currency_exchanges", p2PCurrencyExchangeCreate.asJson());
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, P2PCurrencyExchange.class);
    }

}
