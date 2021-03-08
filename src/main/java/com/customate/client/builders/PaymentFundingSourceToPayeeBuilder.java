package com.customate.client.builders;

import com.customate.client.enums.Currency;
import com.customate.client.models.PaymentFundingSourceToPayeeCreate;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.UUID;

/**
 * Builds a funding source to payee payment.
 *
 * Date: 03-Mar-21
 * Time: 1:27 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class PaymentFundingSourceToPayeeBuilder {

    private long amount;
    private String description;
    private Currency currency;
    private String executionDate;
    private JsonNode metadata;
    private UUID fundingSourceId;
    private UUID payeeId;

    /**
     * Sets the amount.
     *
     * @param amount  Amount.
     * @return PaymentFundingSourceToPayeeBuilder  The updated funding source to payee payment builder.
     */
    public PaymentFundingSourceToPayeeBuilder setAmount(long amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Sets the description.
     *
     * @param description  Description.
     * @return PaymentFundingSourceToPayeeBuilder  The updated funding source to payee payment builder.
     */
    public PaymentFundingSourceToPayeeBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Sets the currency.
     *
     * @param currency  Currency.
     * @return PaymentFundingSourceToPayeeBuilder  The updated funding source to payee payment builder.
     */
    public PaymentFundingSourceToPayeeBuilder setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Sets the execution date.
     *
     * @param executionDate  Execution date in YYYY-MM-DD format.
     * @return PaymentFundingSourceToPayeeBuilder  The updated funding source to payee payment builder.
     */
    public PaymentFundingSourceToPayeeBuilder setExecutionDate(String executionDate) {
        this.executionDate = executionDate;
        return this;
    }

    /**
     * Sets the metadata.
     *
     * @param metadata  Metadata.
     * @return PaymentFundingSourceToPayeeBuilder  The updated funding source to payee payment builder.
     */
    public PaymentFundingSourceToPayeeBuilder setMetadata(JsonNode metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Sets the funding source ID.
     *
     * @param fundingSourceId  Funding source ID.
     * @return PaymentFundingSourceToPayeeBuilder  The updated funding source to payee payment builder.
     */
    public PaymentFundingSourceToPayeeBuilder setFundingSourceId(UUID fundingSourceId) {
        this.fundingSourceId = fundingSourceId;
        return this;
    }

    /**
     * Sets the payee ID.
     *
     * @param payeeId  Payee ID.
     * @return PaymentFundingSourceToPayeeBuilder  The updated funding source to payee payment builder.
     */
    public PaymentFundingSourceToPayeeBuilder setPayeeId(UUID payeeId) {
        this.payeeId = payeeId;
        return this;
    }

    /**
     * Builds a funding source to payee payment.
     *
     * @return PaymentFundingSourceToPayeeCreate  The funding source to payee payment.
     */
    public PaymentFundingSourceToPayeeCreate build() {
        return new PaymentFundingSourceToPayeeCreate(amount, description, currency, executionDate, metadata, fundingSourceId, payeeId);
    }

}
