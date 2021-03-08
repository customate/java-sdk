package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Models a page of payees.
 * 
 * Date: 19-Feb-21
 * Time: 5:00 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PayeePage extends BaseModel {

    @JsonProperty("items")
    private List<Payee> items;
    @JsonProperty("meta")
    private Pagination meta;

    /**
     * Default constructor.
     */
    public PayeePage() { }

}
