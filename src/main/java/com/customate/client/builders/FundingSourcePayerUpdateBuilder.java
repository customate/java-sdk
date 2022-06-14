package com.customate.client.builders;

import com.customate.client.models.FundingSourceAddress;
import com.customate.client.models.FundingSourcePayer;
import com.customate.client.models.FundingSourceUpdatePayer;

/**
 * Builds a payer for updating a funding source.
 *
 * Date: 13-Jun-22
 * Time: 13:51 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class FundingSourcePayerUpdateBuilder {

    private String email;
    private FundingSourceAddress fundingSourceAddress;

    /**
     * Sets the email.
     *
     * @param email  Email.
     * @return FundingSourcePayerBuilder  Updated funding source payer builder.
     */
    public FundingSourcePayerUpdateBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * Sets the funding source address.
     *
     * @param fundingSourceAddress  Funding source address.
     * @return FundingSourcePayerBuilder  Updated funding source payer builder.
     */
    public FundingSourcePayerUpdateBuilder setFundingSourceAddress(FundingSourceAddress fundingSourceAddress) {
        this.fundingSourceAddress = fundingSourceAddress;
        return this;
    }

    /**
     * Builds a funding source payer for update.
     *
     * @return FundingSourceUpdatePayer  The FundingSourceUpdatePayer.
     */
    public FundingSourceUpdatePayer build() {
        return new FundingSourceUpdatePayer(email, fundingSourceAddress);
    }
}
