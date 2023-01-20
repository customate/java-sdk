package com.customate.client.models;

import com.customate.client.enums.Currency;
import com.customate.client.enums.OpenBankingFeeOptionId;
import com.customate.client.enums.OpenBankingMandatePeriod;
import com.customate.client.enums.OpenBankingSchemeId;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * Models an open banking mandate (for creation).
 *
 * Date: 19-Jan-23
 * Time: 3:34 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenBankingMandateCreate extends BaseModel {

    @JsonProperty("provider_id")
    private String providerId;
    /**
     * 2-digit ISO country code.
     */
    @JsonProperty("country")
    private String country;
    @JsonProperty("currency")
    private Currency currency;
    @JsonProperty("payer_name")
    private String payerName;
    @JsonProperty("payer_email")
    private String payerEmail;
    @JsonProperty("beneficiary_name")
    private String beneficiaryName;
    @JsonProperty("maximum_individual_amount")
    private long maximumIndividualAmount;
    @JsonProperty("maximum_payment_amount")
    private long maximumPaymentAmount;
    @JsonProperty("maximum_payment_period")
    private String maximumPaymentPeriod;
    @JsonProperty("reference")
    private String reference;
    @JsonProperty("redirect_url")
    private String redirectUrl;
    @JsonProperty("valid_from_date")
    private String validFromDate;
    @JsonProperty("valid_to_date")
    private String validToDate;

    /**
     * Default constructor.
     */
    public OpenBankingMandateCreate() { }

    /**
     * Constructor.
     *
     * @param providerId  Provider ID (the bank).
     * @param country  2-digit ISO country code (GB only).
     * @param currency  Currency (GBP only).
     * @param payerName  Payer name.
     * @param payerEmail  Payer email.
     * @param beneficiaryName  Beneficiary name.
     * @param maximumIndividualAmount  Maximum amount per payment.
     * @param maximumPaymentAmount  Maximum amount in the specified period.
     * @param maximumPaymentPeriod  Period that the maximum amount applies to.
     * @param reference  Mandate reference.
     * @param redirectUrl  Redirect URL on your site to redirect your user after creating the mandate.
     * @param validFromDate  Date the mandate is valid from (cannot be in the past, will be set to the start of the day).
     * @param validToDate  Date the mandate is valid to (will be set to the end of the day).
     */
    public OpenBankingMandateCreate(String providerId, String country, Currency currency, String payerName,
                                    String payerEmail, String beneficiaryName, long maximumIndividualAmount,
                                    long maximumPaymentAmount, OpenBankingMandatePeriod maximumPaymentPeriod,
                                    String reference, String redirectUrl, String validFromDate, String validToDate) {
        this.providerId = providerId;
        this.country = country;
        this.currency = currency;
        this.payerName = payerName;
        this.payerEmail = payerEmail;
        this.beneficiaryName = beneficiaryName;
        this.maximumIndividualAmount = maximumIndividualAmount;
        this.maximumPaymentAmount = maximumPaymentAmount;
        this.maximumPaymentPeriod = maximumPaymentPeriod.toString().toLowerCase(); // Lower case for creation
        this.reference = reference;
        this.redirectUrl = redirectUrl;
        this.validFromDate = validFromDate;
        this.validToDate = validToDate;
    }

}
