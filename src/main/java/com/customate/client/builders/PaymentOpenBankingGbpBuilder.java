package com.customate.client.builders;

import com.customate.client.enums.Currency;
import com.customate.client.enums.OpenBankingSchemeId;
import com.customate.client.models.PaymentOpenBankingGbpCreate;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Builds a GBP open banking payment.
 *
 * Date: 01-Mar-21
 * Time: 3:23 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class PaymentOpenBankingGbpBuilder {

    private long amount;
    private String description;
    private String country;
    private Currency currency;
    private String webhookUri;
    private String redirectUri;
    private JsonNode metadata;
    private String providerId;
    private OpenBankingSchemeId schemeId;
    private String payerName;
    private String beneficiaryName;

    /**
     * Sets the amount.
     *
     * @param amount  Amount.
     * @return PaymentOpenBankingGbpBuilder  The updated payment open banking builder.
     */
    public PaymentOpenBankingGbpBuilder setAmount(long amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Sets the description.
     *
     * @param description  Description.
     * @return PaymentOpenBankingGbpBuilder  The updated payment open banking builder.
     */
    public PaymentOpenBankingGbpBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Sets the country.
     *
     * @param country  Country.
     * @return PaymentOpenBankingGbpBuilder  The updated payment open banking builder.
     */
    public PaymentOpenBankingGbpBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    /**
     * Sets the currency.
     *
     * @param currency  Currency.
     * @return PaymentOpenBankingGbpBuilder  The updated payment open banking builder.
     */
    public PaymentOpenBankingGbpBuilder setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Sets the webhook URI.
     *
     * @param webhookUri  Webhook URI.
     * @return PaymentOpenBankingGbpBuilder  The updated payment open banking builder.
     */
    public PaymentOpenBankingGbpBuilder setWebhookUri(String webhookUri) {
        this.webhookUri = webhookUri;
        return this;
    }

    /**
     * Sets the redirect URI.
     *
     * @param redirectUri  Redirect URI.
     * @return PaymentOpenBankingGbpBuilder  The updated payment open banking builder.
     */
    public PaymentOpenBankingGbpBuilder setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
        return this;
    }

    /**
     * Sets the metadata.
     *
     * @param metadata  Metadata.
     * @return PaymentOpenBankingGbpBuilder  The updated payment open banking builder.
     */
    public PaymentOpenBankingGbpBuilder setMetadata(JsonNode metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Sets the provider ID.
     *
     * @param providerId  Provider ID.
     * @return PaymentOpenBankingGbpBuilder  The updated payment open banking builder.
     */
    public PaymentOpenBankingGbpBuilder setProviderId(String providerId) {
        this.providerId = providerId;
        return this;
    }

    /**
     * Sets the scheme ID.
     *
     * @param openBankingSchemeId  Scheme ID.
     * @return PaymentOpenBankingGbpBuilder  The updated payment open banking builder.
     */
    public PaymentOpenBankingGbpBuilder setSchemeId(OpenBankingSchemeId openBankingSchemeId) {
        this.schemeId = openBankingSchemeId;
        return this;
    }

    /**
     * Sets the payer name.
     *
     * @param payerName  Payer name.
     * @return PaymentOpenBankingGbpBuilder  The updated payment open banking builder.
     */
    public PaymentOpenBankingGbpBuilder setPayerName(String payerName) {
        this.payerName = payerName;
        return this;
    }

    /**
     * Sets the beneficiary name.
     *
     * @param beneficiaryName  Beneficiary name.
     * @return PaymentOpenBankingGbpBuilder  The updated payment open banking builder.
     */
    public PaymentOpenBankingGbpBuilder setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
        return this;
    }

    /**
     * Builds a GBP open banking payment.
     *
     * @return PaymentOpenBankingGbpCreate  The GBP open banking payment.
     */
    public PaymentOpenBankingGbpCreate build() {
        return new PaymentOpenBankingGbpCreate(amount, description, country, currency, webhookUri, redirectUri, metadata,
                                               providerId, schemeId, payerName, beneficiaryName);
    }

}
