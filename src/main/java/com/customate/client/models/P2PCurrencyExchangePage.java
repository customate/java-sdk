package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Models a page of P2P currency exchanges.
 * 
 * Date: 09-Aug-22
 * Time: 3:36 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class P2PCurrencyExchangePage extends BaseModel {

    @JsonProperty("items")
    private List<P2PCurrencyExchange> items;
    @JsonProperty("meta")
    private Pagination meta;

    /**
     * Default constructor.
     */
    public P2PCurrencyExchangePage() { }

}
