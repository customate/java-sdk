package com.customate.client.services;

import com.customate.client.CustomateClient;
import com.customate.client.exceptions.ApiException;
import com.customate.client.models.P2PCurrencyExchange;
import com.customate.client.models.RFQGetQuoteRequest;
import com.customate.client.models.RFQGetQuoteResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.UUID;

/**
 *
 * Date: 30-Aug-22
 * Time: 5:30 PM
 *
 * @author Abhishek
 * @version 1.0
 */
public class RFQCurrencyExchangeService {

    public static RFQGetQuoteResponse getQuote(UUID profileId, RFQGetQuoteRequest rfqGetQuoteRequest)
        throws URISyntaxException, IOException, InterruptedException, ApiException {
            HttpResponse<String> response =
                    CustomateClient.post("profiles/" + profileId + "/currency_exchanges", rfqGetQuoteRequest.asJson());
            String responseBody = response.body();
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(responseBody, RFQGetQuoteResponse.class);
    }

    public static String executeQuote(UUID profileId, UUID quoteId) throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response =
                CustomateClient.put("profiles/" + profileId + "/currency_exchanges/" + quoteId + "/execute_quote","");
        String responseBody = response.body();
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.readValue(responseBody, RFQGetQuoteResponse.class);
        return responseBody;
    }
}
