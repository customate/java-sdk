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
    private Currency currency;
    private Currency counterpartyCurrency;
    private BigDecimal exchangeRate;
    private UUID fundingSourceId;
    private UUID counterpartyPayeeId;
    private String executionDate;
    private String additionalInformation;

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
     * @param currency  Currency to sell.
     * @return P2PCurrencyExchangeBuilder  The updated P2P currency exchange builder.
     */
    public P2PCurrencyExchangeBuilder setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Sets the counterparty currency to buy.
     *
     * @param counterpartyCurrency  Currency to buy.
     * @return P2PCurrencyExchangeBuilder  The updated P2P currency exchange builder.
     */
    public P2PCurrencyExchangeBuilder setCounterpartyCurrency(Currency counterpartyCurrency) {
        this.counterpartyCurrency = counterpartyCurrency;
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
     * Sets the funding source ID.
     *
     * @param fundingSourceId  Funding Source ID.
     * @return P2PCurrencyExchangeBuilder  The updated P2P currency exchange builder.
     */
    public P2PCurrencyExchangeBuilder setFundingSourceId(UUID fundingSourceId) {
        this.fundingSourceId = fundingSourceId;
        return this;
    }

    /**
     * Sets the counterparty's payee ID.
     *
     * @param counterpartyPayeeId  Counterparty Payee ID.
     * @return P2PCurrencyExchangeBuilder  The updated P2P currency exchange builder.
     */
    public P2PCurrencyExchangeBuilder setCounterpartyPayeeId(UUID counterpartyPayeeId) {
        this.counterpartyPayeeId = counterpartyPayeeId;
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
     * @param additionalInformation  Additional information.
     * @return P2PCurrencyExchangeBuilder  The updated P2P currency exchange builder.
     */
    public P2PCurrencyExchangeBuilder setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
        return this;
    }

    /**
     * Builds a P2P currency exchange.
     *
     * @return PaymentWalletToPayeeCreate  The P2P currency exchange.
     */
    public P2PCurrencyExchangeCreate build() {
        return new P2PCurrencyExchangeCreate(amount, currency, counterpartyCurrency, exchangeRate,
                fundingSourceId, counterpartyPayeeId, executionDate, additionalInformation);
    }

}
