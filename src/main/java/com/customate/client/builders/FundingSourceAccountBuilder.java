package com.customate.client.builders;

import com.customate.client.models.FundingSourceAccount;

/**
 * Builds an account for a funding source.
 *
 * Date: 12-Feb-21
 * Time: 2:19 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class FundingSourceAccountBuilder {

    private String sortCode;
    private String accountNumber;

    /**
     * Sets the sort code.
     *
     * @param sortCode  Sort code.
     * @return FundingSourceAccountBuilder  Updated funding source account builder.
     */
    public FundingSourceAccountBuilder setSortCode(String sortCode) {
        this.sortCode = sortCode;
        return this;
    }

    /**
     * Sets the account number.
     *
     * @param accountNumber  account number.
     * @return FundingSourceAccountBuilder  Updated funding source account builder.
     */
    public FundingSourceAccountBuilder setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    /**
     * Builds a funding source account.
     *
     * @return FundingSourceAccount  The FundingSourceAccount.
     */
    public FundingSourceAccount build() {
        return new FundingSourceAccount(sortCode, accountNumber);
    }
}
