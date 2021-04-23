package com.customate.client.builders;

import com.customate.client.enums.Currency;
import com.customate.client.enums.OpenBankingFeeOptionId;
import com.customate.client.enums.OpenBankingSchemeId;
import com.customate.client.models.PaymentOpenBankingEurCreate;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Builds a Euro open banking payment.
 *
 * Date: 01-Mar-21
 * Time: 3:23 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class PaymentOpenBankingEurBuilder {

    private long amount;
    private String description;
    private String country;
    private Currency currency;
    private String webhookUri;
    private String redirectUri;
    private JsonNode metadata;
    private String providerId;
    private OpenBankingSchemeId schemeId;
    private String payerIban;
    private String payerName;
    private String beneficiaryName;

    /**
     * Sets the amount.
     *
     * @param amount  Amount.
     * @return PaymentOpenBankingEurBuilder  The updated payment open banking builder.
     */
    public PaymentOpenBankingEurBuilder setAmount(long amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Sets the description.
     *
     * @param description  Description.
     * @return PaymentOpenBankingEurBuilder  The updated payment open banking builder.
     */
    public PaymentOpenBankingEurBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Sets the country.
     *
     * @param country  Country.
     * @return PaymentOpenBankingEurBuilder  The updated payment open banking builder.
     */
    public PaymentOpenBankingEurBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    /**
     * Sets the currency.
     *
     * @param currency  Currency.
     * @return PaymentOpenBankingEurBuilder  The updated payment open banking builder.
     */
    public PaymentOpenBankingEurBuilder setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Sets the webhook URI.
     *
     * @param webhookUri  Webhook URI.
     * @return PaymentOpenBankingEurBuilder  The updated payment open banking builder.
     */
    public PaymentOpenBankingEurBuilder setWebhookUri(String webhookUri) {
        this.webhookUri = webhookUri;
        return this;
    }

    /**
     * Sets the redirect URI.
     *
     * @param redirectUri  Redirect URI.
     * @return PaymentOpenBankingEurBuilder  The updated payment open banking builder.
     */
    public PaymentOpenBankingEurBuilder setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
        return this;
    }

    /**
     * Sets the metadata.
     *
     * @param metadata  Metadata.
     * @return PaymentOpenBankingEurBuilder  The updated payment open banking builder.
     */
    public PaymentOpenBankingEurBuilder setMetadata(JsonNode metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Sets the provider ID.
     *
     * @param providerId  Provider ID.
     * @return PaymentOpenBankingEurBuilder  The updated payment open banking builder.
     */
    public PaymentOpenBankingEurBuilder setProviderId(String providerId) {
        this.providerId = providerId;
        return this;
    }

    /**
     * Sets the scheme ID.
     *
     * @param schemeId  Scheme ID.
     * @return PaymentOpenBankingEurBuilder  The updated payment open banking builder.
     */
    public PaymentOpenBankingEurBuilder setSchemeId(OpenBankingSchemeId schemeId) {
        this.schemeId = schemeId;
        return this;
    }

    /**
     * Sets the payer IBAN.
     *
     * @param payerIban  Payer IBAN.
     * @return PaymentOpenBankingEurBuilder  The updated payment open banking builder.
     */
    public PaymentOpenBankingEurBuilder setPayerIban(String payerIban) {
        this.payerIban = payerIban;
        return this;
    }

    /**
     * Sets the payer name.
     *
     * @param payerName  Payer name.
     * @return PaymentOpenBankingEurBuilder  The updated payment open banking builder.
     */
    public PaymentOpenBankingEurBuilder setPayerName(String payerName) {
        this.payerName = payerName;
        return this;
    }

    /**
     * Sets the beneficiary name.
     *
     * @param beneficiaryName  Beneficiary name.
     * @return PaymentOpenBankingEurBuilder  The updated payment open banking builder.
     */
    public PaymentOpenBankingEurBuilder setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
        return this;
    }

    /**
     * Builds a Euro open banking payment.
     *
     * @return PaymentOpenBankingEurCreate  The Euro open banking payment.
     */
    public PaymentOpenBankingEurCreate build() {
        return new PaymentOpenBankingEurCreate(amount, description, country, currency, webhookUri, redirectUri,
                                               metadata, providerId, schemeId, payerIban, payerName, beneficiaryName);
    }

}
