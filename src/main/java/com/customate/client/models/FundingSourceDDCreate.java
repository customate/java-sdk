package com.customate.client.models;

import com.customate.client.enums.Currency;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Models a direct debit funding source (used on creation).
 * 
 * Date: 10-Mar-21
 * Time: 3:04 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class FundingSourceDDCreate extends BaseModel {

    @JsonProperty("title")
    private String title;
    @JsonProperty("currency")
    private Currency currency;
    @JsonProperty("data")
    private FundingSourceCreateData fundingSourceCreateData;

    /**
     * Default constructor.
     */
    public FundingSourceDDCreate() { }

    /**
     * Constructor.
     *
     * @param title  Title.
     * @param currency  Currency.
     * @param fundingSourceCreateData  Funding source data for creation.
     */
    public FundingSourceDDCreate(String title, Currency currency, FundingSourceCreateData fundingSourceCreateData) {
        this.title = title;
        this.currency = currency;
        this.fundingSourceCreateData = fundingSourceCreateData;
    }
}
