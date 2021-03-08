package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * Models the data returned after creating an open banking payment.
 *
 * Date: 02-Mar-21
 * Time: 2:04 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentOpenBankingData extends BaseModel {

    @JsonProperty("type")
    private String type;
    @JsonProperty("id")
    private UUID id;
    @JsonProperty("attributes")
    private PaymentOpenBankingDataAttributes paymentOpenBankingDataAttributes;
    @JsonProperty("relationships")
    private PaymentOpenBankingDataRelationships paymentOpenBankingDataRelationships;

    /**
     * Default constructor.
     */
    public PaymentOpenBankingData() { }

}
