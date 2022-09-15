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
 * Services to get a currency exchange rate quote, execute a quote and get a list of exchanges.
 *
 * Date: 30-Aug-22
 * Time: 5:30 PM
 *
 * @author Abhishek
 * @version 1.0
 */
public class CurrencyExchangeService {

    /**
     * Gets all currency exchanges for a profile.
     *
     * @param profileId  Profile ID.
     * @return CurrencyExchangePage  A page of currency exchanges.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static CurrencyExchangePage getAll(UUID profileId) throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("profiles/" + profileId + "/currency_exchanges");
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, CurrencyExchangePage.class);
    }

    /**
     * Gets a page of currency exchanges for a profile.
     *
     * @param profileId  Profile ID.
     * @param pageNum  The page number (the first page is page 1).
     * @param pageSize  The page size.
     * @return CurrencyExchangePage  A page of currency exchanges.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static CurrencyExchangePage getPage(UUID profileId, int pageNum, int pageSize)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("profiles/" + profileId + "/currency_exchanges?page[number]=" + pageNum + "&page[size]=" + pageSize);
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, CurrencyExchangePage.class);
    }

    /**
     * Gets a currency exchange for a profile.
     *
     * @param profileId  Profile ID.
     * @param currencyExchangeId  The currency exchange ID.
     * @return CurrencyExchange  The currency exchange.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static CurrencyExchange get(UUID profileId, UUID currencyExchangeId) throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("profiles/" + profileId + "/currency_exchanges/" + currencyExchangeId);
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, CurrencyExchange.class);
    }

    /**
     * Gets a currency exchange quote for a profile.
     *
     * @param profileId  Profile ID.
     * @param currencyExchangeCreate  The CurrencyExchangeCreate to get a quote for.
     * @return CurrencyExchange  The currency exchange including the quoted exchange rate.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static CurrencyExchange getQuote(UUID profileId, CurrencyExchangeCreate currencyExchangeCreate)
        throws URISyntaxException, IOException, InterruptedException, ApiException {
            HttpResponse<String> response =
                    CustomateClient.post("profiles/" + profileId + "/currency_exchanges", currencyExchangeCreate.asJson());
            String responseBody = response.body();
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(responseBody, CurrencyExchange.class);
    }

    /**
     * Executes the currency exchange.
     *
     * @param profileId  Profile ID.
     * @param quoteId  The ID of the quote (valid for 30 seconds).
     * @return CurrencyExchangeExecuteQuoteResponse  The response, including the ID and a message.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static CurrencyExchangeExecuteQuoteResponse execute(UUID profileId, UUID quoteId)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response =
                CustomateClient.put("profiles/" + profileId + "/currency_exchanges/" + quoteId + "/execute_quote","");
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, CurrencyExchangeExecuteQuoteResponse.class);
    }
}
