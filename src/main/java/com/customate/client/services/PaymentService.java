package com.customate.client.services;

import com.customate.client.CustomateClient;
import com.customate.client.enums.Currency;
import com.customate.client.enums.SortOrder;
import com.customate.client.exceptions.ApiException;
import com.customate.client.models.*;
import com.customate.client.utils.UrlHelper;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

/**
 * Services for payments.
 *
 * Date: 01-Mar-21
 * Time: 2:53 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class PaymentService {

    /**
     * Gets all payments for a profile.
     *
     * @param profileId  Profile ID.
     * @return PaymentPage  A page of payments.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static PaymentPage getAll(UUID profileId) throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("profiles/" + profileId + "/payments");
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, PaymentPage.class);
    }

    /**
     * Gets filtered and sorted payments for a profile.
     *
     * @param profileId  Profile ID.
     * @param filters  Map of filter keys and values.
     * @param sortField  Field to sort on.
     * @param sortOrder  Sort order: asc or desc.
     * @return PaymentPage  A page of payments.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static PaymentPage getAll(UUID profileId, Map<String, String> filters, String sortField, SortOrder sortOrder)
            throws URISyntaxException, IOException, InterruptedException, ApiException {

        // Build the query string
        String queryString = UrlHelper.createQueryString(filters, sortField, sortOrder);

        HttpResponse<String> response = CustomateClient.get("profiles/" + profileId + "/payments" + queryString);
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, PaymentPage.class);
    }

    /**
     * Gets a page of payments for a profile.
     *
     * @param profileId  Profile ID.
     * @param pageNum  The page number (the first page is page 1).
     * @param pageSize  The page size.
     * @return PaymentPage  A page of payments.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static PaymentPage getPage(UUID profileId, int pageNum, int pageSize)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("profiles/" + profileId + "/payments?page[number]=" + pageNum + "&page[size]=" + pageSize);
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, PaymentPage.class);
    }

    /**
     * Gets a page of filtered and sorted payments for a profile.
     *
     * @param profileId  Profile ID.
     * @param filters  Map of filter keys and values.
     * @param sortField  Field to sort on.
     * @param sortOrder  Sort order: asc or desc.
     * @param pageNum  The page number (the first page is page 1).
     * @param pageSize  The page size.
     * @return PaymentPage  A page of payments.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static PaymentPage getPage(UUID profileId, Map<String, String> filters,
                                      String sortField, SortOrder sortOrder, int pageNum, int pageSize)
            throws URISyntaxException, IOException, InterruptedException, ApiException {

        // Build the query string
        String queryString = UrlHelper.createQueryString(filters, sortField, sortOrder);

        HttpResponse<String> response = CustomateClient.get("profiles/" + profileId + "/payments" + queryString + "&page[number]=" + pageNum + "&page[size]=" + pageSize);
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, PaymentPage.class);
    }

    /**
     * Gets a payment for a profile.
     *
     * @param profileId  Profile ID.
     * @param paymentId  Payment ID.
     * @return Payment  The payment.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static Payment get(UUID profileId, UUID paymentId) throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("profiles/" + profileId + "/payments/" + paymentId);
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, Payment.class);
    }

    /**
     * Gets open banking providers.
     *
     * @param currency  Currency.
     * @param country  2-digit ISO country code.
     * @return PaymentOpenBankingProviderPage  The list of providers.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static PaymentOpenBankingProviderPage getOpenBankingProviders(Currency currency, String country)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.get("open_banking_providers?currency=" + currency.toString() + "&country=" + country);
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, PaymentOpenBankingProviderPage.class);
    }

    /**
     * Creates a GBP open banking payment (the JSON format is different when creating and getting payments).
     *
     * @param profileId  Profile ID.
     * @param paymentOpenBankingGbpCreate  The GBP open banking payment to create.
     * @return PaymentOpenBanking  The open banking payment.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static PaymentOpenBanking createOpenBankingGbp(UUID profileId, PaymentOpenBankingGbpCreate paymentOpenBankingGbpCreate)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response =
                CustomateClient.post("profiles/" + profileId + "/open_banking_to_wallet_payments",
                                     paymentOpenBankingGbpCreate.asJson());
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, PaymentOpenBanking.class);
    }

    /**
     * Creates a Euro open banking payment (the JSON format is different when creating and getting payments).
     *
     * @param profileId  Profile ID.
     * @param paymentOpenBankingEurCreate  The Euro open banking payment to create.
     * @return PaymentOpenBanking  The open banking payment.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static PaymentOpenBanking createOpenBankingEur(UUID profileId, PaymentOpenBankingEurCreate paymentOpenBankingEurCreate)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response =
                CustomateClient.post("profiles/" + profileId + "/open_banking_to_wallet_payments",
                                     paymentOpenBankingEurCreate.asJson());
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, PaymentOpenBanking.class);
    }

    /**
     * Creates an open banking mandate payment (the JSON format is different when creating and getting payments).
     *
     * @param profileId  Profile ID.
     * @param paymentOpenBankingMandateCreate  The open banking mandate payment to create.
     * @return PaymentOpenBanking  The open banking payment.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static PaymentOpenBanking createOpenBankingGbp(UUID profileId, PaymentOpenBankingMandateCreate paymentOpenBankingMandateCreate)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response =
                CustomateClient.post("profiles/" + profileId + "/open_banking_to_wallet_mandate_payments",
                                     paymentOpenBankingMandateCreate.asJson());
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, PaymentOpenBanking.class);
    }

    /**
     * Creates a wallet to bank account payment (the JSON format is different when creating and getting payments).
     *
     * @param profileId  Profile ID.
     * @param paymentWalletToPayeeCreate  The wallet to payee payment to create.
     * @return Payment  The (wallet to bank account) payment.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static Payment createWalletToBankAccount(UUID profileId, PaymentWalletToPayeeCreate paymentWalletToPayeeCreate)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.post("profiles/" + profileId + "/wallet_to_bank_account_payments",
                paymentWalletToPayeeCreate.asJson());
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, Payment.class);
    }

    /**
     * Creates a wallet to wallet payment (the JSON format is different when creating and getting payments).
     *
     * @param profileId  Profile ID.
     * @param paymentWalletToPayeeCreate  The wallet to payee payment to create.
     * @return Payment  The (wallet to wallet) payment.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static Payment createWalletToWallet(UUID profileId, PaymentWalletToPayeeCreate paymentWalletToPayeeCreate)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.post("profiles/" + profileId + "/wallet_to_wallet_payments",
                paymentWalletToPayeeCreate.asJson());
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, Payment.class);
    }

    /**
     * Creates a single direct debit to wallet payment (the JSON format is different when creating and getting payments).
     *
     * @param profileId  Profile ID.
     * @param paymentFundingSourceToPayeeCreate  The payment to create.
     * @return Payment  The payment.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static Payment createDirectDebitToWallet(UUID profileId, PaymentFundingSourceToPayeeCreate paymentFundingSourceToPayeeCreate)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.post("profiles/" + profileId + "/direct_debit_to_wallet_payments",
                paymentFundingSourceToPayeeCreate.asJson());
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, Payment.class);
    }

    /**
     * Creates a (funding source to payee) payment (the JSON format is different when creating and getting payments).
     *
     * @param profileId  Profile ID.
     * @param paymentFundingSourceToPayeeCreate  The payment to create.
     * @return Payment  The payment.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static Payment create(UUID profileId, PaymentFundingSourceToPayeeCreate paymentFundingSourceToPayeeCreate)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.post("profiles/" + profileId + "/payments",
                paymentFundingSourceToPayeeCreate.asJson());
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, Payment.class);
    }

    /**
     * Creates a services payment. Simulates an incoming bank payment. Sandbox only.
     * Returns the ID of the saxo_transferinstruction in the customate_sandbox database.
     *
     * @param profileId  Profile ID.
     * @param paymentServiceCreate  The services payment to create.
     * @return SaxoTransferInstruction  The ID of the Saxo transfer instruction.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static SaxoTransferInstruction createService(UUID profileId, PaymentServiceCreate paymentServiceCreate)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.post("profiles/" + profileId + "/service_payments", paymentServiceCreate.asJson());
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, SaxoTransferInstruction.class);
    }

    /**
     * Gets dates (in a range) that payments will not be processed on (as banks are not open on those days).
     *
     * @param intervalStartDate  Start date. The current date will be used if not set.
     * @param intervalEndDate  End date. Current date +1 month will be used if not set.
     * @return List<Date>  A list of dates.
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static NonProcessingDates getNonProcessingDates(LocalDate intervalStartDate, LocalDate intervalEndDate)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        String url = "non_processing_dates";
        if (intervalStartDate != null || intervalEndDate != null) {
            url += "?";
            if (intervalStartDate != null) {
                url += "interval_start_date=" + intervalStartDate;
                if (intervalEndDate != null) {
                    url += "&interval_end_date=" + intervalEndDate;
                }
            } else {
                url += "interval_end_date=" + intervalEndDate;
            }
        }
        HttpResponse<String> response = CustomateClient.get(url);
        String responseBody = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, NonProcessingDates.class);
    }

    /**
     * Deletes a payment.
     *
     * @param profileId  Profile ID.
     * @param paymentId  Payment ID.
     * @return int  Status code (204 expected).
     * @throws URISyntaxException  If there was a problem creating the URI.
     * @throws IOException  If there was an IO error sending the request.
     * @throws InterruptedException  If there was an interrupted exception sending the request.
     * @throws ApiException  If the API returned errors.
     */
    public static int delete(UUID profileId, UUID paymentId)
            throws URISyntaxException, IOException, InterruptedException, ApiException {
        HttpResponse<String> response = CustomateClient.delete("profiles/" + profileId + "/payments/" + paymentId);
        return response.statusCode();
    }

}
