package com.customate.client.models;

import com.customate.client.enums.Currency;
import com.customate.client.enums.CurrencyExchangeStatus;
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
    @JsonProperty("funding_source_id")
    private UUID fundingSourceId;
    @JsonProperty("amount")
    private long amount;
    /**
     * 3-digit ISO currency code
     */
    @JsonProperty("currency")
    private Currency currency;
    @JsonProperty("exchange_rate")
    private BigDecimal exchangeRate;
    /**
     * 3-digit ISO currency code
     */
    @JsonProperty("counterparty_currency")
    private Currency counterpartyCurrency;
    @JsonProperty("counterparty_amount")
    private long counterpartyAmount;
    @JsonProperty("counterparty_payee_id")
    private UUID counterpartyPayeeId;
    @JsonProperty("counterparty_email")
    private String counterpartyEmail;
    @JsonProperty("additional_information")
    private String additionalInformation;
    /**
     * Execution date in in YYYY-MM-DD format.
     */
    @JsonProperty("execution_date")
    private String executionDate;

    /**
     * Default constructor.
     */
    public P2PCurrencyExchange() { }

}
