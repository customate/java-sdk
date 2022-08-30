package com.customate.client.models;

import com.customate.client.enums.Currency;
import com.customate.client.enums.CurrencyExchangeStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

/**
 *
 * Date: 30-Aug-22
 * Time: 5:30 PM
 *
 * @author Abhishek
 * @version 1.0
 */

@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class RFQGetQuoteResponse extends BaseModel{
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
     * Expiry date in in YYYY-MM-DD format.
     */
    @JsonProperty("expiry_date")
    private String expiryDate;
    /**
     * Expiry date time in in YYYY-MM-DDTHH:MM:SS.Millis format.
     */
    @JsonProperty("expiry_datetime")
    private String expiryDateTime;
    /**
     * 3-digit ISO currency code
     */
    @JsonProperty("amount_currency")
    private Currency amountCurrency;
    @JsonProperty("description")
    private String description;

    /**
     * Default constructor.
     */
    public RFQGetQuoteResponse() { }
}
