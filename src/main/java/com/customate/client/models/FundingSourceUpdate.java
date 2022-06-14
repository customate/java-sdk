package com.customate.client.models;

import com.customate.client.enums.Currency;
import com.customate.client.enums.FundingSourceType;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Models a funding source (used on update).
 * 
 * Date: 13-Jun-22
 * Time: 12:47 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class FundingSourceUpdate extends BaseModel {

    @JsonProperty("title")
    private String title;
    @JsonProperty("payer")
    private FundingSourceUpdatePayer fundingSourceUpdatePayer;

    /**
     * Default constructor.
     */
    public FundingSourceUpdate() { }

    /**
     * Constructor.
     *
     * @param title  Title.
     * @param fundingSourceUpdatePayer  Funding source payer for update.
     */
    public FundingSourceUpdate(String title, FundingSourceUpdatePayer fundingSourceUpdatePayer) {
        this.title = title;
        this.fundingSourceUpdatePayer = fundingSourceUpdatePayer;
    }
}
