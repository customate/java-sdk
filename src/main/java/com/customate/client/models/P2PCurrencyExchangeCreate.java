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
    @JsonProperty("currency")
    private Currency currency;
    /**
     * 3-digit ISO currency code
     */
    @JsonProperty("counterparty_currency")
    private Currency counterpartyCurrency;
    @JsonProperty("exchange_rate")
    private BigDecimal exchangeRate;
    @JsonProperty("funding_source_id")
    private UUID fundingSourceId;
    @JsonProperty("counterparty_payee_id")
    private UUID counterpartyPayeeId;
    /**
     * Execution date in in YYYY-MM-DD format.
     */
    @JsonProperty("execution_date")
    private String executionDate;
    @JsonProperty("additional_information")
    private String additionalInformation;

    /**
     * Default constructor.
     */
    public P2PCurrencyExchangeCreate() { }

    /**
     * Constructor.
     *
     * @param amount  Amount in pence/cents.
     * @param currency  Currency to sell.
     * @param counterpartyCurrency  Currency to buy from counterparty.
     * @param exchangeRate  Exchange rate as a big decimal.
     * @param fundingSourceId  Funding source ID in the currency to sell.
     * @param counterpartyPayeeId  Counterparty's payee ID in the currency to buy.
     * @param executionDate  Execution date in in YYYY-MM-DD format.
     * @param additionalInformation  Additional information.
     */
    public P2PCurrencyExchangeCreate(long amount, Currency currency, Currency counterpartyCurrency, BigDecimal exchangeRate,
                                     UUID fundingSourceId, UUID counterpartyPayeeId, String executionDate, String additionalInformation) {
        this.amount = amount;
        this.currency = currency;
        this.counterpartyCurrency = counterpartyCurrency;
        this.exchangeRate = exchangeRate;
        this.fundingSourceId = fundingSourceId;
        this.counterpartyPayeeId = counterpartyPayeeId;
        this.executionDate = executionDate;
        this.additionalInformation = additionalInformation;
    }

}
