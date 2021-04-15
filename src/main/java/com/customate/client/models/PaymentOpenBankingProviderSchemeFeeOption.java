package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models a TrueLayer fee option within a provider scheme.
 *
 * Date: 07-Apr-21
 * Time: 12:49 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
@ToString
public class PaymentOpenBankingProviderSchemeFeeOption extends BaseModel {
    @JsonProperty("fee_option_id")
    private String feeOptionId;
    @JsonProperty("beneficiary_fee")
    private String beneficiaryFee;
    @JsonProperty("remitter_fee")
    private String remitterFee;

    /**
     * Default constructor.
     */
    public PaymentOpenBankingProviderSchemeFeeOption() { }
}
