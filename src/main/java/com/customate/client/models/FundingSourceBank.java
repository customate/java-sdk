package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models a bank (in funding source data).
 *
 * Date: 12-Feb-21
 * Time: 12:14 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class FundingSourceBank extends BaseModel {

    @JsonProperty("name")
    private String name;
    @JsonProperty("address")
    private FundingSourceAddress fundingSourceAddress;

    /**
     * Default constructor.
     */
    public FundingSourceBank() { }

}
