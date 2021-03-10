package com.customate.client.builders;

import com.customate.client.enums.Currency;
import com.customate.client.models.FundingSourceCreateData;
import com.customate.client.models.FundingSourceDDCreate;

/**
 * Builds a direct debit funding source.
 *
 * Date: 10-Mar-21
 * Time: 3:04 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class FundingSourceDDBuilder {

    private String title;
    private Currency currency;
    private FundingSourceCreateData fundingSourceCreateData;

    /**
     * Sets the title.
     *
     * @param title  Title.
     * @return FundingSourceBuilder  Updated funding source builder.
     */
    public FundingSourceDDBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Sets the currency.
     *
     * @param currency  Currency.
     * @return FundingSourceBuilder  Updated funding source builder.
     */
    public FundingSourceDDBuilder setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Sets the funding source data (for creation).
     *
     * @param fundingSourceCreateData  Funding source create data.
     * @return FundingSourceBuilder  Updated funding source builder.
     */
    public FundingSourceDDBuilder setFundingSourceCreateData(FundingSourceCreateData fundingSourceCreateData) {
        this.fundingSourceCreateData = fundingSourceCreateData;
        return this;
    }

    /**
     * Builds a direct debit funding source (for creation).
     *
     * @return FundingSourceDDCreate  The direct debit funding source.
     */
    public FundingSourceDDCreate build() {
        return new FundingSourceDDCreate(title, currency, fundingSourceCreateData);
    }
}
