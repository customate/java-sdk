package com.customate.client.builders;

import com.customate.client.enums.Currency;
import com.customate.client.enums.FundingSourceType;
import com.customate.client.models.FundingSourceCreate;
import com.customate.client.models.FundingSourceCreateData;
import com.customate.client.models.FundingSourceUpdate;
import com.customate.client.models.FundingSourceUpdatePayer;

/**
 * Builds a funding source for update.
 *
 * Date: 13-Jun-22
 * Time: 13:46 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class FundingSourceUpdateBuilder {

    private String title;
    private FundingSourceUpdatePayer fundingSourceUpdatePayer;

    /**
     * Sets the title.
     *
     * @param title  Title.
     * @return FundingSourceUpdateBuilder  Updated funding source builder.
     */
    public FundingSourceUpdateBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Sets the payer.
     *
     * @param fundingSourceUpdatePayer  Funding source payer (for update).
     * @return FundingSourceUpdateBuilder  Updated funding source builder.
     */
    public FundingSourceUpdateBuilder setFundingSourceUpdatePayer(FundingSourceUpdatePayer fundingSourceUpdatePayer) {
        this.fundingSourceUpdatePayer = fundingSourceUpdatePayer;
        return this;
    }

    /**
     * Builds a funding source (for update).
     *
     * @return FundingSourceUpdate  The funding source.
     */
    public FundingSourceUpdate build() {
        return new FundingSourceUpdate(title, fundingSourceUpdatePayer);
    }
}
