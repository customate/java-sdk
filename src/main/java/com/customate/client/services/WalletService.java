package com.customate.client.services;

import com.customate.client.CustomateClient;
import com.customate.client.enums.Currency;
import com.customate.client.exceptions.ApiException;
import com.customate.client.models.AllWalletPage;
import com.customate.client.models.WalletPage;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Services for wallets.
 *
 * Date: 11-Feb-21
 * Time: 2:51 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class WalletService {

    /**
     * Gets all wallets for a profile.
     *
     * @param profileId  Profile ID.
     * @return WalletPage  A page of wallets.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static WalletPage getAll(UUID profileId) throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("profiles/" + profileId + "/wallets");
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, WalletPage.class);
    }

    /**
     * Gets a page of wallets for a profile.
     *
     * @param profileId  Profile ID.
     * @param pageNum  The page number (the first page is page 1).
     * @param pageSize  The page size.
     * @return WalletPage  A page of wallets.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static WalletPage getPage(UUID profileId, int pageNum, int pageSize)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("profiles/" + profileId + "/wallets?page[number]=" + pageNum + "&page[size]=" + pageSize);
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, WalletPage.class);
    }

    /**
     * Gets all wallets for a client, with pagination and totals.
     *
     * @param currency  Currency (GBP, EUR, USD).
     * @param date  Report date - start of day.
     * @param pageNum  The page number (the first page is page 1).
     * @param pageSize  The page size.
     * @return AllWalletPage  All wallets with pagination and totals.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static AllWalletPage getAllWallets(Currency currency, Date date, int pageNum, int pageSize)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        String startOfDay = new SimpleDateFormat("yyyy-MM-dd").format(date);
        HttpResponse<String> response =
                CustomateClient.get("all_wallets?currency=" + currency + "&date=" + startOfDay + "&page_number=" + pageNum + "&page_size=" + pageSize);
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, AllWalletPage.class);
    }

}
