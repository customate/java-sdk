package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Models a page of (real, not peer-to-peer) currency exchanges.
 * 
 * Date: 12-Sep-22
 * Time: 2:07 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyExchangePage extends BaseModel {

    @JsonProperty("items")
    private List<CurrencyExchange> items;
    @JsonProperty("meta")
    private Pagination meta;

    /**
     * Default constructor.
     */
    public CurrencyExchangePage() { }

}
