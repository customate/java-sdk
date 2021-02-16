package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models a funding source payer.
 *
 * Date: 12-Feb-21
 * Time: 12:53 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class FundingSourcePayer extends BaseModel {

    @JsonProperty("full_name")
    private String fullName;

    /**
     * Default constructor.
     */
    public FundingSourcePayer() { }

    /**
     * Constructor.
     *
     * @param fullName  Full name.
     */
    public FundingSourcePayer(String fullName) {
        this.fullName = fullName;
    }
}
