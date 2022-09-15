package com.customate.client.builders;

import com.customate.client.enums.Currency;
import com.customate.client.models.CurrencyExchangeCreate;
import com.customate.client.models.P2PCurrencyExchangeCreate;
import com.fasterxml.jackson.databind.JsonNode;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Builds a (real, not P2P) currency exchange payment.
 *
 * Date: 12-Sep-22
 * Time: 2:08 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class CurrencyExchangeBuilder {

    private long amount;
    private Currency currencyToSell;
    private Currency currencyToBuy;
    private BigDecimal exchangeRate;
    private String description;
    private JsonNode metadata;

    /**
     * Sets the amount.
     *
     * @param amount  Amount.
     * @return CurrencyExchangeBuilder  The updated currency exchange builder.
     */
    public CurrencyExchangeBuilder setAmount(long amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Sets the currency to sell.
     *
     * @param currencyToSell  Currency to sell.
     * @return CurrencyExchangeBuilder  The updated currency exchange builder.
     */
    public CurrencyExchangeBuilder setCurrencyToSell(Currency currencyToSell) {
        this.currencyToSell = currencyToSell;
        return this;
    }

    /**
     * Sets the currency to buy.
     *
     * @param currencyToBuy  Currency to buy.
     * @return CurrencyExchangeBuilder  The updated currency exchange builder.
     */
    public CurrencyExchangeBuilder setCurrencyToBuy(Currency currencyToBuy) {
        this.currencyToBuy = currencyToBuy;
        return this;
    }

    /**
     * Sets the description.
     *
     * @param description  Description.
     * @return CurrencyExchangeBuilder  The updated currency exchange builder.
     */
    public CurrencyExchangeBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Sets the metadata.
     *
     * @param metadata  Metadata.
     * @return CurrencyExchangeBuilder  The updated currency exchange builder.
     */
    public CurrencyExchangeBuilder setMetadata(JsonNode metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Builds a currency exchange to get a quote.
     *
     * @return CurrencyExchangeCreate  The currency exchange.
     */
    public CurrencyExchangeCreate build() {
        return new CurrencyExchangeCreate(amount, currencyToSell, currencyToBuy, description, metadata);
    }

}
