package com.customate.client.builders;

import com.customate.client.models.FundingSourcePayer;

/**
 * Builds a payer for a funding source.
 *
 * Date: 12-Feb-21
 * Time: 2:32 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class FundingSourcePayerBuilder {

    private String fullName;

    /**
     * Sets the full name.
     *
     * @param fullName  Full name.
     * @return FundingSourcePayerBuilder  Updated funding source payer builder.
     */
    public FundingSourcePayerBuilder setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    /**
     * Builds a funding source payer.
     *
     * @return FundingSourcePayer  The FundingSourcePayer.
     */
    public FundingSourcePayer build() {
        return new FundingSourcePayer(fullName);
    }
}
