package com.customate.client.builders;

import com.customate.client.enums.FundingSourceOwnership;
import com.customate.client.models.FundingSourceAccount;
import com.customate.client.models.FundingSourceCreateData;
import com.customate.client.models.FundingSourcePayer;

/**
 * Builds funding source data.
 *
 * Date: 12-Feb-21
 * Time: 13:44 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class FundingSourceDataBuilder {

    private FundingSourceOwnership fundingSourceOwnership;
    private FundingSourcePayer fundingSourcePayer;
    private FundingSourceAccount fundingSourceAccount;

    /**
     * Sets the funding source ownership.
     *
     * @param fundingSourceOwnership  Funding source ownership.
     * @return FundingSourceDataBuilder  Updated funding source data builder.
     */
    public FundingSourceDataBuilder setFundingSourceOwnership(FundingSourceOwnership fundingSourceOwnership) {
        this.fundingSourceOwnership = fundingSourceOwnership;
        return this;
    }

    /**
     * Sets the funding source payer.
     *
     * @param fundingSourcePayer  Funding source payer.
     * @return FundingSourceDataBuilder  Updated funding source data builder.
     */
    public FundingSourceDataBuilder setFundingSourcePayer(FundingSourcePayer fundingSourcePayer) {
        this.fundingSourcePayer = fundingSourcePayer;
        return this;
    }

    /**
     * Sets the funding source account.
     *
     * @param fundingSourceAccount  Funding source account.
     * @return FundingSourceDataBuilder  Updated funding source data builder.
     */
    public FundingSourceDataBuilder setFundingSourceAccount(FundingSourceAccount fundingSourceAccount) {
        this.fundingSourceAccount = fundingSourceAccount;
        return this;
    }

    /**
     * Builds funding source data (for creation).
     *
     * @return FundingSourceCreateData  The funding source data.
     */
    public FundingSourceCreateData build() {
        return new FundingSourceCreateData(fundingSourceOwnership, fundingSourcePayer, fundingSourceAccount);
    }
}
