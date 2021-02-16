package com.customate.client.builders;

import com.customate.client.enums.Currency;
import com.customate.client.enums.FundingSourceType;
import com.customate.client.models.FundingSourceCreate;
import com.customate.client.models.FundingSourceCreateData;

/**
 * Builds a funding source.
 *
 * Date: 12-Feb-21
 * Time: 12:42 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class FundingSourceBuilder {

    private String title;
    private Currency currency;
    private FundingSourceType fundingSourceType;
    private FundingSourceCreateData fundingSourceCreateData;

    /**
     * Sets the title.
     *
     * @param title  Title.
     * @return FundingSourceBuilder  Updated funding source builder.
     */
    public FundingSourceBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Sets the currency.
     *
     * @param currency  Currency.
     * @return FundingSourceBuilder  Updated funding source builder.
     */
    public FundingSourceBuilder setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Sets the funding source type.
     *
     * @param fundingSourceType  Funding source type.
     * @return FundingSourceBuilder  Updated funding source builder.
     */
    public FundingSourceBuilder setFundingSourceType(FundingSourceType fundingSourceType) {
        this.fundingSourceType = fundingSourceType;
        return this;
    }

    /**
     * Sets the funding source data (for creation).
     *
     * @param fundingSourceCreateData  Funding source create data.
     * @return FundingSourceBuilder  Updated funding source builder.
     */
    public FundingSourceBuilder setFundingSourceCreateData(FundingSourceCreateData fundingSourceCreateData) {
        this.fundingSourceCreateData = fundingSourceCreateData;
        return this;
    }

    /**
     * Builds a funding source (for creation).
     *
     * @return FundingSource  The funding source.
     */
    public FundingSourceCreate build() {
        return new FundingSourceCreate(title, currency, fundingSourceType, fundingSourceCreateData);
    }
}
