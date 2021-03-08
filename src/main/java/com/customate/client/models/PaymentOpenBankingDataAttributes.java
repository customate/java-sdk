package com.customate.client.models;

import com.customate.client.enums.Currency;
import com.customate.client.enums.PaymentScenario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * Models the sub-data returned after creating an open banking payment.
 *
 * Date: 02-Mar-21
 * Time: 2:08 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentOpenBankingDataAttributes extends BaseModel {

    @JsonProperty("currency")
    private Currency currency;
    @JsonProperty("data")
    private PaymentOpenBankingDataAttributesData paymentOpenBankingDataAttributesData;
    @JsonProperty("metadata")
    private PaymentOpenBankingDataAttributesMetadata paymentOpenBankingDataAttributesMetadata;
    @JsonProperty("scenario")
    private PaymentScenario paymentScenario;
    @JsonProperty("status")
    private com.customate.client.enums.OpenBankingPaymentStatus OpenBankingPaymentStatus;
    @JsonProperty("walletId")
    private UUID walletId;

    /**
     * Default constructor.
     */
    public PaymentOpenBankingDataAttributes() { }

}
