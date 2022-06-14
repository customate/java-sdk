package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Models a funding source (used in validation).
 * 
 * Date: 14-Jun-22
 * Time: 2:45 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class FundingSourceValidate extends BaseModel {

    @JsonProperty("title")
    private String title;
    @JsonProperty("payer")
    private FundingSourceValidatePayer fundingSourceValidatePayer;

    /**
     * Default constructor.
     */
    public FundingSourceValidate() { }

    /**
     * Constructor.
     *
     * @param title  Title.
     * @param fundingSourceValidatePayer  Funding source payer for validation.
     */
    public FundingSourceValidate(String title, FundingSourceValidatePayer fundingSourceValidatePayer) {
        this.title = title;
        this.fundingSourceValidatePayer = fundingSourceValidatePayer;
    }
}
