package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Models a page of transactions.
 * 
 * Date: 11-Feb-21
 * Time: 3:48 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionPage extends BaseModel {

    @JsonProperty("items")
    private List<Transaction> items;
    @JsonProperty("meta")
    private Pagination meta;

    /**
     * Default constructor.
     */
    public TransactionPage() { }

}
