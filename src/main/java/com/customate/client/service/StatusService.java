package com.customate.client.service;

import com.customate.client.CustomateClient;
import com.customate.client.exceptions.ApiException;
import com.customate.client.models.Status;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;

/**
 * Services for the API status.
 *
 * Date: 08-Feb-21
 * Time: 2:40 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class StatusService {

    @Autowired
    private static CustomateClient customateClient;

    /**
     * Gets the API status.
     *
     * @return Status  A status object.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static Status get() throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = customateClient.get("status");
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, Status.class);
    }
}
