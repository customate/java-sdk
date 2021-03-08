package com.customate.client.builders;

import com.customate.client.enums.PaymentScenario;
import com.customate.client.models.PaymentServiceCreate;

import java.util.UUID;

/**
 * Builds a services payment. Simulates an incoming bank payment. Sandbox only.
 *
 * Date: 03-Mar-21
 * Time: 2:20 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class PaymentServiceBuilder {

    private long amount;
    private String description;
    private PaymentScenario paymentScenario;
    private UUID payeeId;

    /**
     * Sets the amount.
     *
     * @param amount  Amount.
     * @return PaymentServiceBuilder  The updated services payment builder.
     */
    public PaymentServiceBuilder setAmount(long amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Sets the description.
     *
     * @param description  Description.
     * @return PaymentServiceBuilder  The updated services payment builder.
     */
    public PaymentServiceBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Sets the currency.
     *
     * @param paymentScenario  Payment scenario - should be IncomingBankTransfer.
     * @return PaymentServiceBuilder  The updated services payment builder.
     */
    public PaymentServiceBuilder setPaymentScenario(PaymentScenario paymentScenario) {
        this.paymentScenario = paymentScenario;
        return this;
    }

    /**
     * Sets the payee ID.
     *
     * @param payeeId  Payee ID.
     * @return PaymentServiceBuilder  The updated services payment builder.
     */
    public PaymentServiceBuilder setPayeeId(UUID payeeId) {
        this.payeeId = payeeId;
        return this;
    }

    /**
     * Builds a services payment.
     *
     * @return PaymentServiceCreate  The services payment.
     */
    public PaymentServiceCreate build() {
        return new PaymentServiceCreate(amount, description, paymentScenario, payeeId);
    }

}
