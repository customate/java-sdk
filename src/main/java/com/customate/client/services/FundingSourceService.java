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
 * Services for funding sources.
 *
 * Date: 11-Feb-21
 * Time: 2:51 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class FundingSourceService {

    /**
     * Gets a funding source for a profile.
     *
     * @param profileId  Profile ID.
     * @param fundingSourceId  Funding source ID.
     * @return FundingSource  The funding source.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static FundingSource get(UUID profileId, UUID fundingSourceId)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("profiles/" + profileId + "/funding_sources/" + fundingSourceId);
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, FundingSource.class);
    }

    /**
     * Gets all funding sources for a profile.
     *
     * @param profileId  Profile ID.
     * @return FundingSourcePage  A page of funding sources.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static FundingSourcePage getAll(UUID profileId) throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("profiles/" + profileId + "/funding_sources");
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, FundingSourcePage.class);
    }

    /**
     * Gets a page of funding sources for a profile.
     *
     * @param profileId  Profile ID.
     * @param pageNum  The page number (the first page is page 1).
     * @param pageSize  The page size.
     * @return FundingSourcePage  A page of funding sources.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static FundingSourcePage getPage(UUID profileId, int pageNum, int pageSize)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("profiles/" + profileId + "/funding_sources?page[number]=" + pageNum + "&page[size]=" + pageSize);
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, FundingSourcePage.class);
    }

    /**
     * Creates a funding source (the JSON format is different when creating and getting funding sources).
     *
     * @param profileId  Profile ID.
     * @param fundingSourceCreate  The funding source to create.
     * @return Funding Source  The funding source.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static FundingSource create(UUID profileId, FundingSourceCreate fundingSourceCreate)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response =
                CustomateClient.post("profiles/" + profileId + "/funding_sources", fundingSourceCreate.asJson());
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, FundingSource.class);
    }

    /**
     * Creates a direct debit funding source (the JSON format is different when creating and getting funding sources).
     *
     * @param profileId  Profile ID.
     * @param fundingSourceDDCreate  The direct debit funding source to create.
     * @return Funding Source  The funding source.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static FundingSource createDirectDebit(UUID profileId, FundingSourceDDCreate fundingSourceDDCreate)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response =
                CustomateClient.post("profiles/" + profileId + "/direct_debit_funding_sources", fundingSourceDDCreate.asJson());
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, FundingSource.class);
    }

    /**
     * Renames a funding source.
     *
     * @param profileId  Profile ID.
     * @param fundingSourceId  Funding source ID.
     * @param name  New funding source name (title).
     * @return Funding Source  The funding source.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static FundingSource rename(UUID profileId, UUID fundingSourceId, String name)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        TitleName fundingSourceTitle = new TitleName(name);
        HttpResponse<String> response =
                CustomateClient.put("profiles/" + profileId + "/funding_sources/" + fundingSourceId, fundingSourceTitle.asJson());
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, FundingSource.class);
    }

    /**
     * Deletes a funding source.
     *
     * @param profileId  Profile ID.
     * @param fundingSourceId  Funding source ID.
     * @return int  Status code (204 expected).
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static int delete(UUID profileId, UUID fundingSourceId)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.delete("profiles/" + profileId + "/funding_sources/" + fundingSourceId);
        return response.statusCode();
    }

}
