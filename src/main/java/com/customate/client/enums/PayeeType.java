package com.customate.client.enums;

/**
 * Enumeration of payee types.
 * 
 * Date: 19-Feb-21
 * Time: 4:48 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public enum PayeeType {
    bank_account("bank_account"),
    wallet("wallet"),
    virtual_wallet("virtual_wallet");

    private String payeeType;

    /**
     * Constructor.
     *
     * @param payeeType  The payee type as a string.
     */
    PayeeType(String payeeType) {
        this.payeeType = payeeType;
    }

    /**
     * Returns the payee type as a string.
     */
    @Override
    public String toString() {
        return payeeType;
    }

    /**
     * Gets the payee type from the input string.
     *
     * @param text  Payee type to find.
     * @return PayeeType  The payee type found.
     */
    public static PayeeType fromString(String text) {
        for (PayeeType payeeType : PayeeType.values()) {
            if (payeeType.payeeType.equalsIgnoreCase(text)) {
                return payeeType;
            }
        }
        return null;
    }
}
