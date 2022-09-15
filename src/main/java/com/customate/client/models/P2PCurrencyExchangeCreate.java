package com.customate.client.models;

import com.customate.client.enums.Currency;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Models a P2P currency exchange for creation.
 *
 * Date: 08-Aug-22
 * Time: 4:13 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class P2PCurrencyExchangeCreate extends BaseModel {

    @JsonProperty("amount")
    private long amount;
    /**
     * 3-digit ISO currency code
     */
    @JsonProperty("currency_to_sell")
    private Currency currencyToSell;
    @JsonProperty("exchange_rate")
    private BigDecimal exchangeRate;
    @JsonProperty("payee_id")
    private UUID payeeId;
    /**
     * Execution date in in YYYY-MM-DD format.
     */
    @JsonProperty("execution_date")
    private String executionDate;
    @JsonProperty("description")
    private String description;
    @JsonProperty("metadata")
    private JsonNode metadata;

    /**
     * Default constructor.
     */
    public P2PCurrencyExchangeCreate() { }

    /**
     * Constructor.
     *
     * @param amount  Amount in pence/cents.
     * @param currencyToSell  Currency to sell.
     * @param exchangeRate  Exchange rate as a big decimal.
     * @param payeeId  Counterparty's payee ID in the currency to buy.
     * @param executionDate  Execution date in in YYYY-MM-DD format.
     * @param description  Additional information.
     * @param metadata  Metadata.
     */
    public P2PCurrencyExchangeCreate(long amount, Currency currencyToSell, BigDecimal exchangeRate, UUID payeeId,
                                     String executionDate, String description, JsonNode metadata) {
        this.amount = amount;
        this.currencyToSell = currencyToSell;
        this.exchangeRate = exchangeRate;
        this.payeeId = payeeId;
        this.executionDate = executionDate;
        this.description = description;
        this.metadata = metadata;
    }

}
