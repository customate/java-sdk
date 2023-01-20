package com.customate.client.models;

import com.customate.client.enums.Currency;
import com.customate.client.enums.OpenBankingSchemeId;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.customate.client.enums.OpenBankingMandatePeriod;

import java.util.UUID;

/**
 * Models an open banking mandate.
 *
 * Date: 18-Jan-23
 * Time: 2:50 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenBankingMandateData extends BaseModel {

    @JsonProperty("period")
    private String maximumPaymentPeriod;
    /**
     * 2-digit ISO country code.
     */
    @JsonProperty("country")
    private String country;
    @JsonProperty("currency")
    private Currency currency;
    @JsonProperty("reference")
    private String reference;
    @JsonProperty("scheme_id")
    private OpenBankingSchemeId schemeId;
    @JsonProperty("account_id")
    private UUID accountId;
    @JsonProperty("payer_name")
    private String payerName;
    @JsonProperty("payer_email")
    private String payer_email;
    @JsonProperty("provider_id")
    private String providerId;
    @JsonProperty("redirect_url")
    private String redirectUrl;
    @JsonProperty("valid_from_date")
    private String validFromDate;
    @JsonProperty("valid_to_date")
    private String validToDate;
    @JsonProperty("beneficiary_name")
    private String beneficiaryName;
    @JsonProperty("maximum_payment_amount")
    private long maximumPaymentAmount;
    @JsonProperty("maximum_individual_amount")
    private long maximumIndividualAmount;

    /**
     * Default constructor.
     */
    public OpenBankingMandateData() { }

}
