package com.customate.client.builders;

import com.customate.client.models.PayeeAccount;

/**
 * Builds an account for a payee.
 *
 * Date: 26-Feb-21
 * Time: 1:36 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class PayeeAccountBuilder {

    private String iban;
    private String sortCode;
    private String accountNumber;

    /**
     * Sets the IBAN.
     *
     * @param iban  IBAN.
     * @return PayeeAccountBuilder  Updated payee account builder.
     */
    public PayeeAccountBuilder setIban(String iban) {
        this.iban = iban;
        return this;
    }

    /**
     * Sets the sort code.
     *
     * @param sortCode  Sort code.
     * @return PayeeAccountBuilder  Updated payee account builder.
     */
    public PayeeAccountBuilder setSortCode(String sortCode) {
        this.sortCode = sortCode;
        return this;
    }

    /**
     * Sets the account number.
     *
     * @param accountNumber  account number.
     * @return PayeeAccountBuilder  Updated payee account builder.
     */
    public PayeeAccountBuilder setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    /**
     * Builds a payee account.
     *
     * @return PayeeAccount  The PayeeAccount.
     */
    public PayeeAccount build() {
        return new PayeeAccount(iban, sortCode, accountNumber);
    }

}
