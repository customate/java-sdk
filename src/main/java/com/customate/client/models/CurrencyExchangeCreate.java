package com.customate.client.models;

import com.customate.client.enums.Currency;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * Models a (real, not peer-to-peer) currency exchange quote for creation.
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
public class CurrencyExchangeCreate extends BaseModel {

    @JsonProperty("amount")
    private long amount;

    /**
     * 3-digit ISO currency code
     */
    @JsonProperty("currency_to_sell")
    private Currency currencyToSell;

    /**
     * 3-digit ISO currency code
     */
    @JsonProperty("currency_to_buy")
    private Currency currencyToBuy;

    @JsonProperty("description")
    private String description;

    @JsonProperty("metadata")
    private JsonNode metadata;

    /**
     * Default constructor.
     */
    public CurrencyExchangeCreate() { }

    /**
     * Constructor.
     *
     * @param amount  Amount in pence/cents.
     * @param currencyToSell  Currency to sell.
     * @param currencyToBuy  Currency to buy.
     * @param description  Additional information.
     * @param metadata  Metadata.
     */
    public CurrencyExchangeCreate(long amount, Currency currencyToSell, Currency currencyToBuy,
                                  String description, JsonNode metadata) {
        this.amount = amount;
        this.currencyToSell = currencyToSell;
        this.currencyToBuy = currencyToBuy;
        this.description = description;
        this.metadata = metadata;
    }

}
