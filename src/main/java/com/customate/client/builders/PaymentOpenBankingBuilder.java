package com.customate.client.builders;

import com.customate.client.enums.Currency;
import com.customate.client.models.PaymentOpenBankingCreate;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Builds an open banking payment.
 *
 * Date: 01-Mar-21
 * Time: 3:23 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class PaymentOpenBankingBuilder {

    private long amount;
    private String description;
    private String country;
    private Currency currency;
    private String webhookUri;
    private String redirectUri;
    private JsonNode metadata;

    /**
     * Sets the amount.
     *
     * @param amount  Amount.
     * @return PaymentOpenBankingBuilder  The updated payment open banking builder.
     */
    public PaymentOpenBankingBuilder setAmount(long amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Sets the description.
     *
     * @param description  Description.
     * @return PaymentOpenBankingBuilder  The updated payment open banking builder.
     */
    public PaymentOpenBankingBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Sets the country.
     *
     * @param country  Country.
     * @return PaymentOpenBankingBuilder  The updated payment open banking builder.
     */
    public PaymentOpenBankingBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    /**
     * Sets the currency.
     *
     * @param currency  Currency.
     * @return PaymentOpenBankingBuilder  The updated payment open banking builder.
     */
    public PaymentOpenBankingBuilder setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Sets the webhook URI.
     *
     * @param webhookUri  Webhook URI.
     * @return PaymentOpenBankingBuilder  The updated payment open banking builder.
     */
    public PaymentOpenBankingBuilder setWebhookUri(String webhookUri) {
        this.webhookUri = webhookUri;
        return this;
    }

    /**
     * Sets the redirect URI.
     *
     * @param redirectUri  Redirect URI.
     * @return PaymentOpenBankingBuilder  The updated payment open banking builder.
     */
    public PaymentOpenBankingBuilder setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
        return this;
    }

    /**
     * Sets the metadata.
     *
     * @param metadata  Metadata.
     * @return PaymentOpenBankingBuilder  The updated payment open banking builder.
     */
    public PaymentOpenBankingBuilder setMetadata(JsonNode metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Builds an open banking payment.
     *
     * @return PaymentOpenBankingCreate  The open banking payment.
     */
    public PaymentOpenBankingCreate build() {
        return new PaymentOpenBankingCreate(amount, description, country, currency, webhookUri, redirectUri, metadata);
    }

}
