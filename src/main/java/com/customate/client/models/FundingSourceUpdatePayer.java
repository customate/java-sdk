package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models a funding source payer (for update).
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
public class FundingSourceUpdatePayer extends BaseModel {

    @JsonProperty("email")
    private String email;

    @JsonProperty("address")
    private FundingSourceAddress fundingSourceAddress;

    /**
     * Default constructor.
     */
    public FundingSourceUpdatePayer() { }

    /**
     * Constructor.
     *
     * @param email  Email address.
     * @param fundingSourceAddress  Funding source address.
     */
    public FundingSourceUpdatePayer(String email, FundingSourceAddress fundingSourceAddress) {
        this.email = email;
        this.fundingSourceAddress = fundingSourceAddress;
    }
}
