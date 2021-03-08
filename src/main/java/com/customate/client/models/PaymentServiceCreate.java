package com.customate.client.models;

import com.customate.client.enums.PaymentScenario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * Models a services payment (for creation). Simulates an incoming bank payment. Sandbox only.
 *
 * Date: 03-Mar-21
 * Time: 2:15 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentServiceCreate extends BaseModel {

    @JsonProperty("amount")
    private long amount;
    @JsonProperty("description")
    private String description;
    @JsonProperty("scenario")
    private PaymentScenario paymentScenario;
    @JsonProperty("payee_id")
    private UUID payeeId;

    /**
     * Default constructor.
     */
    public PaymentServiceCreate() { }

    /**
     * Constructor.
     *
     * @param amount  Amount in pence/cents.
     * @param description  Description of payment.
     * @param paymentScenario  Payment scenario - should be IncomingBankTransfer.
     * @param payeeId  ID of the payee.
     */
    public PaymentServiceCreate(long amount, String description, PaymentScenario paymentScenario, UUID payeeId) {
        this.amount = amount;
        this.description = description;
        this.paymentScenario = paymentScenario;
        this.payeeId = payeeId;
    }

}
