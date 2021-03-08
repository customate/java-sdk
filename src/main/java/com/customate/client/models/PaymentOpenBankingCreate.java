package com.customate.client.models;

import com.customate.client.enums.Currency;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models an open banking payment (for creation).
 *
 * Date: 01-Mar-21
 * Time: 3:12 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentOpenBankingCreate extends BaseModel {

    @JsonProperty("amount")
    private long amount;
    @JsonProperty("description")
    private String description;
    /**
     * 2-digit ISO country code.
     */
    @JsonProperty("country")
    private String country;
    @JsonProperty("currency")
    private Currency currency;
    @JsonProperty("webhook_uri")
    private String webhookUri;
    @JsonProperty("redirect_uri")
    private String redirectUri;
    @JsonProperty("metadata")
    private JsonNode metadata;

    /**
     * Default constructor.
     */
    public PaymentOpenBankingCreate() { }

    /**
     * Constructor.
     *
     * @param amount  Amount in pence/cents.
     * @param description  Description of payment.
     * @param country  2-digit ISO country code.
     * @param currency  Currency.
     * @param webhookUri  Webhook URI.
     * @param redirectUri  Redirect URI.
     * @param metadata  Metadata.
     */
    public PaymentOpenBankingCreate(long amount, String description, String country, Currency currency,
                                    String webhookUri, String redirectUri, JsonNode metadata) {
        this.amount = amount;
        this.description = description;
        this.country = country;
        this.currency = currency;
        this.webhookUri = webhookUri;
        this.redirectUri = redirectUri;
        this.metadata = metadata;
    }

}