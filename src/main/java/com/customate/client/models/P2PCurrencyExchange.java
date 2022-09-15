package com.customate.client.models;

import com.customate.client.enums.Currency;
import com.customate.client.enums.CurrencyExchangeStatus;
import com.customate.client.enums.CurrencyExchangeType;
import com.customate.client.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Models a P2P currency exchange - used with GET.
 *
 * Date: 10-Aug-22
 * Time: 5:30 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class P2PCurrencyExchange extends BaseModel {

    @JsonProperty("id")
    private UUID id;
    @JsonProperty("creation_datetime")
    private String creationDatetime;
    @JsonProperty("status")
    private CurrencyExchangeStatus currencyExchangeStatus;
    @JsonProperty("type")
    private CurrencyExchangeType currencyExchangeType;
    @JsonProperty("funding_source_id")
    private UUID fundingSourceId;
    @JsonProperty("amount")
    private long amount;
    /**
     * 3-digit ISO currency code
     */
    @JsonProperty("currency_to_sell")
    private Currency currencyToSell;
    @JsonProperty("exchange_rate")
    private BigDecimal exchangeRate;
    /**
     * 3-digit ISO currency code
     */
    @JsonProperty("currency_to_buy")
    private Currency currencyToBuy;
    @JsonProperty("counterparty_amount")
    private long counterpartyAmount;
    @JsonProperty("payee_id")
    private UUID payeeId;
    @JsonProperty("execution_date")
    private String executionDate;
    @JsonProperty("description")
    private String description;
    @JsonProperty("metadata")
    private JsonNode metadata;

    /**
     * Default constructor.
     */
    public P2PCurrencyExchange() { }

}
