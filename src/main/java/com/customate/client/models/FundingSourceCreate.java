package com.customate.client.models;

import com.customate.client.enums.Currency;
import com.customate.client.enums.FundingSourceType;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Models a funding source (used on creation).
 * 
 * Date: 12-Feb-21
 * Time: 1:08 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class FundingSourceCreate extends BaseModel {

    @JsonProperty("title")
    private String title;
    @JsonProperty("currency")
    private Currency currency;
    @JsonProperty("type")
    private FundingSourceType fundingSourceType;
    @JsonProperty("data")
    private FundingSourceCreateData fundingSourceCreateData;

    /**
     * Default constructor.
     */
    public FundingSourceCreate() { }

    /**
     * Constructor.
     *
     * @param title  Title.
     * @param currency  Currency.
     * @param fundingSourceType  Funding source type.
     * @param fundingSourceCreateData  Funding source data for creation.
     */
    public FundingSourceCreate(String title, Currency currency,
                               FundingSourceType fundingSourceType, FundingSourceCreateData fundingSourceCreateData) {
        this.title = title;
        this.currency = currency;
        this.fundingSourceType = fundingSourceType;
        this.fundingSourceCreateData = fundingSourceCreateData;
    }
}
