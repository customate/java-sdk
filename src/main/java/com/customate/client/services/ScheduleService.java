package com.customate.client.services;

import com.customate.client.CustomateClient;
import com.customate.client.enums.FundingSourceType;
import com.customate.client.enums.PayeeType;
import com.customate.client.exceptions.ApiException;
import com.customate.client.models.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.UUID;

/**
 * Services for schedules.
 *
 * Date: 05-Mar-21
 * Time: 10:49 AM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class ScheduleService {

    /**
     * Gets all schedules for a profile.
     *
     * @param profileId  Profile ID.
     * @return SchedulePage  A page of schedules.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static SchedulePage getAll(UUID profileId) throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("profiles/" + profileId + "/schedules");
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, SchedulePage.class);
    }

    /**
     * Gets a page of schedules for a profile.
     *
     * @param profileId  Profile ID.
     * @param pageNum  The page number (the first page is page 1).
     * @param pageSize  The page size.
     * @return SchedulePage  A page of schedules.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static SchedulePage getPage(UUID profileId, int pageNum, int pageSize)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("profiles/" + profileId + "/schedules?page[number]=" + pageNum + "&page[size]=" + pageSize);
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, SchedulePage.class);
    }

    /**
     * Gets a schedule for a profile.
     *
     * @param profileId  Profile ID.
     * @param scheduleId  Schedule ID.
     * @return Schedule  The schedule.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static Schedule get(UUID profileId, UUID scheduleId) throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("profiles/" + profileId + "/schedules/" + scheduleId);
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, Schedule.class);
    }

    /**
     * Creates a schedule.
     *
     * @param profileId  Profile ID.
     * @param scheduleCreate  The schedule to create.
     * @return Schedule  The schedule.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static Schedule create(UUID profileId, ScheduleCreate scheduleCreate)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.post("profiles/" + profileId + "/schedules", scheduleCreate.asJson());
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, Schedule.class);
    }

    /**
     * Updates a schedule.
     *
     * @param profileId  Profile ID.
     * @param scheduleId  Schedule ID.
     * @param scheduleUpdate  The schedule to update.
     * @return Schedule  The updated schedule.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static Schedule update(UUID profileId, UUID scheduleId, ScheduleUpdate scheduleUpdate)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.put("profiles/" + profileId + "/schedules/" + scheduleId, scheduleUpdate.asJson());
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, Schedule.class);
    }

    /**
     * Creates a direct debit to wallet schedule.
     *
     * @param profileId  Profile ID.
     * @param scheduleDDToWalletCreate  The direct debit to wallet schedule to create.
     * @return Schedule  The schedule.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static Schedule createDirectDebitToWallet(UUID profileId, ScheduleDDToWalletCreate scheduleDDToWalletCreate)
            throws URISyntaxException, IOException, InterruptedException, ApiException {

        FundingSource fundingSource = FundingSourceService.get(profileId, scheduleDDToWalletCreate.getFundingSourceId());
        FundingSourceType fundingSourceType = fundingSource.getFundingSourceType();
        Payee payee = PayeeService.get(profileId, scheduleDDToWalletCreate.getPayeeId());
        PayeeType payeeType = payee.getPayeeType();

        if (fundingSourceType != FundingSourceType.direct_debit) {
            throw new ApiException("Cannot create direct debit to wallet schedule as the funding source (type: " + fundingSourceType + ") is not of type direct_debit");
        }
        if (payeeType != PayeeType.wallet) {
            throw new ApiException("Cannot create direct debit to wallet schedule as the payee (type: " + payeeType + ") is not of type wallet");
        }
        HttpResponse<String> response = CustomateClient.post("profiles/" + profileId +
                                                "/direct_debit_to_wallet_schedules", scheduleDDToWalletCreate.asJson());
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, Schedule.class);
    }

    /**
     * Cancels a schedule.
     *
     * @param profileId  Profile ID.
     * @param scheduleId  Schedule ID.
     * @return int  Status code (204 expected).
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static int cancel(UUID profileId, UUID scheduleId)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.delete("profiles/" + profileId + "/schedules/" + scheduleId);
        return response.statusCode();
    }

    /**
     * Pays overdue payments.
     *
     * @param profileId  Profile ID.
     * @param schedule  Schedule.
     * @return int  Status code (204 expected).
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static int payOverduePayments(UUID profileId, Schedule schedule)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response =
                CustomateClient.post("profiles/" + profileId + "/schedules/" + schedule.getId() + "/overdue_processing", schedule.asJson());
        return response.statusCode();
    }

}
