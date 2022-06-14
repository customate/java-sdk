package com.customate.client.builders;

import com.customate.client.models.FundingSourceValidate;
import com.customate.client.models.FundingSourceValidatePayer;
import com.customate.client.models.PayeeValidate;
import com.customate.client.models.PayeeValidateRecipient;

/**
 * Builds a funding source for validation.
 *
 * Date: 14-Jun-22
 * Time: 3:05 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class FundingSourceValidateBuilder {

    private String title;
    private FundingSourceValidatePayer fundingSourceValidatePayer;

    /**
     * Sets the title.
     *
     * @param title  Title.
     * @return FundingSourceValidateBuilder  Updated funding source builder (for validation).
     */
    public FundingSourceValidateBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Sets the payer.
     *
     * @param fundingSourceValidatePayer  Funding source payer (for validation).
     * @return FundingSourceValidateBuilder  Updated funding source builder (for validation).
     */
    public FundingSourceValidateBuilder setFundingSourceValidatePayer(FundingSourceValidatePayer fundingSourceValidatePayer) {
        this.fundingSourceValidatePayer = fundingSourceValidatePayer;
        return this;
    }

    /**
     * Builds a funding source (for validation).
     *
     * @return FundingSourceValidate  The funding source.
     */
    public FundingSourceValidate build() {
        return new FundingSourceValidate(title, fundingSourceValidatePayer);
    }
}
