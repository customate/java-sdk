package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Models an open banking provider scheme (faster_payments_service for GBP, sepa_credit_transfer_instant for EUR).
 *
 * Date: 07-Apr-21
 * Time: 12:58 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
@ToString
public class PaymentOpenBankingProviderScheme extends BaseModel {
    @JsonProperty("scheme_id")
    private String schemeId;
    @JsonProperty("fee_options")
    private List<PaymentOpenBankingProviderSchemeFeeOption> paymentOpenBankingProviderSchemeFeeOptions;

    /**
     * Default constructor.
     */
    public PaymentOpenBankingProviderScheme() { }
}

