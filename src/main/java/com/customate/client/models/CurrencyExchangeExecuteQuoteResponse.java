package com.customate.client.models;

import com.customate.client.enums.Currency;
import com.customate.client.enums.CurrencyExchangeStatus;
import com.customate.client.enums.CurrencyExchangeType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Models the response of executing a (real, not peer-to-perr) currency exchange.
 *
 * Date: 12-Sep-22
 * Time: 2:34 PM
 *
 * @author Sav Balac
 * @version 1.0
 */

@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyExchangeExecuteQuoteResponse extends BaseModel{

    @JsonProperty("result")
    private String result;

    /**
     * Default constructor.
     */
    public CurrencyExchangeExecuteQuoteResponse() { }
}
