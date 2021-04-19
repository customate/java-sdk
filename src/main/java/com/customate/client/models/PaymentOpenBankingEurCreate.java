package com.customate.client.models;

import com.customate.client.enums.Currency;
import com.customate.client.enums.OpenBankingFeeOptionId;
import com.customate.client.enums.OpenBankingSchemeId;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models a Euro open banking payment (for creation).
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
public class PaymentOpenBankingEurCreate extends BaseModel {

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
    @JsonProperty("provider_id")
    private String providerId;
    @JsonProperty("scheme_id")
    private OpenBankingSchemeId schemeId;
    @JsonProperty("fee_option_id")
    private OpenBankingFeeOptionId feeOptionId;
    @JsonProperty("remitter_iban")
    private String remitterIban;
    @JsonProperty("remitter_name")
    private String remitterName;
    @JsonProperty("beneficiary_name")
    private String beneficiaryName;

    /**
     * Default constructor.
     */
    public PaymentOpenBankingEurCreate() { }

    /**
     * Constructor.
     *
     * @param amount  Amount in cents.
     * @param description  Description of payment.
     * @param country  2-digit ISO country code.
     * @param currency  Currency.
     * @param webhookUri  Webhook URI.
     * @param redirectUri  Redirect URI.
     * @param metadata  Metadata.
     * @param providerId  Provider ID (the bank).
     * @param schemeId  Scheme ID.
     * @param feeOptionId  Fee option ID.
     * @param remitterIban  Remitter's IBAN.
     * @param remitterName  Payer name.
     * @param beneficiaryName  Beneficiary name.
     */
    public PaymentOpenBankingEurCreate(long amount, String description, String country, Currency currency,
                                       String webhookUri, String redirectUri, JsonNode metadata, String providerId,
                                       OpenBankingSchemeId schemeId, OpenBankingFeeOptionId feeOptionId,
                                       String remitterIban, String remitterName, String beneficiaryName) {
        this.amount = amount;
        this.description = description;
        this.country = country;
        this.currency = currency;
        this.webhookUri = webhookUri;
        this.redirectUri = redirectUri;
        this.metadata = metadata;
        this.providerId = providerId;
        this.schemeId = schemeId;
        this.feeOptionId = feeOptionId;
        this.remitterIban = remitterIban;
        this.remitterName = remitterName;
        this.beneficiaryName = beneficiaryName;
    }

}
