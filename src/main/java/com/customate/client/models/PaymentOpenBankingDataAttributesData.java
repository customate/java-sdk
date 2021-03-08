package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models the sub-data returned after creating an open banking payment.
 *
 * Date: 02-Mar-21
 * Time: 2:09 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentOpenBankingDataAttributesData extends BaseModel {

    @JsonProperty("amount")
    private long amount;
    @JsonProperty("description")
    private String description;

    /**
     * Default constructor.
     */
    public PaymentOpenBankingDataAttributesData() { }

}
