package com.customate.client.models;

import com.customate.client.enums.FundingSourceOwnership;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Models the funding source data (used on creation).
 * 
 * Date: 12-Feb-21
 * Time: 1:11 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class FundingSourceCreateData extends BaseModel {

    @JsonProperty("ownership")
    private FundingSourceOwnership fundingSourceOwnership;
    @JsonProperty("payer")
    private FundingSourcePayer fundingSourcePayer;
    @JsonProperty("account")
    private FundingSourceAccount fundingSourceAccount;

    /**
     * Default constructor.
     */
    public FundingSourceCreateData() { }

    /**
     * Constructor.
     *
     * @param fundingSourceOwnership  Funding source ownership.
     * @param fundingSourcePayer  Funding source payer.
     * @param fundingSourceAccount  Funding source account.
     */
    public FundingSourceCreateData(FundingSourceOwnership fundingSourceOwnership,
                                   FundingSourcePayer fundingSourcePayer, FundingSourceAccount fundingSourceAccount) {
        this.fundingSourceOwnership = fundingSourceOwnership;
        this.fundingSourcePayer = fundingSourcePayer;
        this.fundingSourceAccount = fundingSourceAccount;
    }
}
