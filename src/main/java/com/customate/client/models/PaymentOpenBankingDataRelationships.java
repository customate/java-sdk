package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models the relationships returned after creating an open banking payment.
 *
 * Date: 02-Mar-21
 * Time: 2:22 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentOpenBankingDataRelationships extends BaseModel {

    @JsonProperty("recipient")
    private PaymentOpenBankingDataRelationshipsRecipient paymentOpenBankingDataRelationshipsRecipient;

    /**
     * Default constructor.
     */
    public PaymentOpenBankingDataRelationships() { }

}
