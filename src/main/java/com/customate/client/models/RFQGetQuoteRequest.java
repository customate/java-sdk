package com.customate.client.models;

import com.customate.client.enums.Currency;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
public class RFQGetQuoteRequest extends BaseModel {
    @JsonProperty("amount")
    private long amount;
    /**
     * 3-digit ISO currency code
     */
    @JsonProperty("amount_currency")
    private Currency amountCurrency;
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

    @JsonProperty("funding_source_id")
    private UUID fundingSourceId;
    @JsonProperty("counterparty_payee_id")
    private UUID counterpartyPayeeId;

    @JsonProperty("description")
    private String description;

    /**
     * Default constructor.
     */
    public RFQGetQuoteRequest() { }
    /**
     * Constructor.
     *
     * @param amount  Amount in pence/cents.
     * @param amountCurrency  amount Currency.
     * @param currency  Currency to sell.
     * @param counterpartyCurrency  Currency to buy from counterparty.
     * @param fundingSourceId  Funding source ID in the currency to sell.
     * @param counterpartyPayeeId  Counterparty's payee ID in the currency to buy.
     * @param description  Additional information.
     */
    public RFQGetQuoteRequest(long amount, Currency amountCurrency, Currency currency, Currency counterpartyCurrency,
                                     UUID fundingSourceId, UUID counterpartyPayeeId, String description) {
        this.amount = amount;
        this.amountCurrency = amountCurrency;
        this.currency = currency;
        this.counterpartyCurrency = counterpartyCurrency;
        this.fundingSourceId = fundingSourceId;
        this.counterpartyPayeeId = counterpartyPayeeId;
        this.description = description;
    }

}
