package com.customate.client.builders;

import com.customate.client.enums.Currency;
import com.customate.client.models.PaymentWalletToPayeeCreate;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.UUID;

/**
 * Builds a wallet to payee payment.
 *
 * Date: 02-Mar-21
 * Time: 11:09 AM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class PaymentWalletToPayeeBuilder {

    private long amount;
    private String description;
    private Currency currency;
    private String executionDate;
    private JsonNode metadata;
    private UUID payeeId;

    /**
     * Sets the amount.
     *
     * @param amount  Amount.
     * @return PaymentWalletToPayeeBuilder  The updated wallet to payee payment builder.
     */
    public PaymentWalletToPayeeBuilder setAmount(long amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Sets the description.
     *
     * @param description  Description.
     * @return PaymentWalletToPayeeBuilder  The updated wallet to payee payment builder.
     */
    public PaymentWalletToPayeeBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Sets the currency.
     *
     * @param currency  Currency.
     * @return PaymentWalletToPayeeBuilder  The updated wallet to payee payment builder.
     */
    public PaymentWalletToPayeeBuilder setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Sets the execution date.
     *
     * @param executionDate  Execution date in YYYY-MM-DD format.
     * @return PaymentWalletToPayeeBuilder  The updated wallet to payee payment builder.
     */
    public PaymentWalletToPayeeBuilder setExecutionDate(String executionDate) {
        this.executionDate = executionDate;
        return this;
    }

    /**
     * Sets the metadata.
     *
     * @param metadata  Metadata.
     * @return PaymentWalletToPayeeBuilder  The updated wallet to payee payment builder.
     */
    public PaymentWalletToPayeeBuilder setMetadata(JsonNode metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Sets the payee ID.
     *
     * @param payeeId  Payee ID.
     * @return PaymentWalletToPayeeBuilder  The updated wallet to payee payment builder.
     */
    public PaymentWalletToPayeeBuilder setPayeeId(UUID payeeId) {
        this.payeeId = payeeId;
        return this;
    }

    /**
     * Builds a wallet to payee payment.
     *
     * @return PaymentWalletToPayeeCreate  The wallet to payee payment.
     */
    public PaymentWalletToPayeeCreate build() {
        return new PaymentWalletToPayeeCreate(amount, description, currency, executionDate, metadata, payeeId);
    }

}
