package com.customate.client.builders;

import com.customate.client.enums.Currency;
import com.customate.client.models.P2PCurrencyExchangeCreate;
import com.fasterxml.jackson.databind.JsonNode;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Builds a P2P currency exchange payment.
 *
 * Date: 09-Aug-22
 * Time: 3:09 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class P2PCurrencyExchangeBuilder {

    private long amount;
    private Currency currencyToSell;
    private BigDecimal exchangeRate;
    private UUID payeeId;
    private String executionDate;
    private String description;
    private JsonNode metadata;

    /**
     * Sets the amount.
     *
     * @param amount  Amount.
     * @return P2PCurrencyExchangeBuilder  The updated P2P currency exchange builder.
     */
    public P2PCurrencyExchangeBuilder setAmount(long amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Sets the currency to sell.
     *
     * @param currencyToSell  Currency to sell.
     * @return P2PCurrencyExchangeBuilder  The updated P2P currency exchange builder.
     */
    public P2PCurrencyExchangeBuilder setCurrency(Currency currencyToSell) {
        this.currencyToSell = currencyToSell;
        return this;
    }

    /**
     * Sets the exchange rate.
     *
     * @param exchangeRate  Exchange rate.
     * @return P2PCurrencyExchangeBuilder  The updated P2P currency exchange builder.
     */
    public P2PCurrencyExchangeBuilder setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
        return this;
    }

    /**
     * Sets the counterparty's payee ID.
     *
     * @param payeeId  Counterparty Payee ID.
     * @return P2PCurrencyExchangeBuilder  The updated P2P currency exchange builder.
     */
    public P2PCurrencyExchangeBuilder setPayeeId(UUID payeeId) {
        this.payeeId = payeeId;
        return this;
    }

    /**
     * Sets the execution date.
     *
     * @param executionDate  Execution date in YYYY-MM-DD format.
     * @return P2PCurrencyExchangeBuilder  The updated P2P currency exchange builder.
     */
    public P2PCurrencyExchangeBuilder setExecutionDate(String executionDate) {
        this.executionDate = executionDate;
        return this;
    }

    /**
     * Sets the description.
     *
     * @param description  Description.
     * @return P2PCurrencyExchangeBuilder  The updated P2P currency exchange builder.
     */
    public P2PCurrencyExchangeBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Sets the metadata.
     *
     * @param metadata  Metadata.
     * @return P2PCurrencyExchangeBuilder  The updated P2P currency exchange builder.
     */
    public P2PCurrencyExchangeBuilder setMetadata(JsonNode metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Builds a P2P currency exchange.
     *
     * @return PaymentWalletToPayeeCreate  The P2P currency exchange.
     */
    public P2PCurrencyExchangeCreate build() {
        return new P2PCurrencyExchangeCreate(amount, currencyToSell, exchangeRate, payeeId, executionDate, description, metadata);
    }

}
