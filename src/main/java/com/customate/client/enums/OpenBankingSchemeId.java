package com.customate.client.enums;

/**
 * Enumeration of open banking scheme IDs.
 * 
 * Date: 19-Apr-21
 * Time: 11:56 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public enum OpenBankingSchemeId {
    faster_payments_service("faster_payments_service"),
    sepa_credit_transfer_instant("sepa_credit_transfer_instant"),
    sepa_credit_transfer("sepa_credit_transfer");

    private String openBankingSchemeId;

    /**
     * Constructor.
     *
     * @param openBankingSchemeId  Open banking scheme ID as a string.
     */
    OpenBankingSchemeId(String openBankingSchemeId) {
        this.openBankingSchemeId = openBankingSchemeId;
    }

    /**
     * Returns the open banking scheme ID as a string.
     */
    @Override
    public String toString() {
        return openBankingSchemeId;
    }

    /**
     * Gets the open banking scheme ID from the input string.
     *
     * @param text  OpenBankingSchemeId to find.
     * @return OpenBankingSchemeId  The open banking scheme ID found.
     */
    public static OpenBankingSchemeId fromString(String text) {
        for (OpenBankingSchemeId openBankingSchemeId : OpenBankingSchemeId.values()) {
            if (openBankingSchemeId.openBankingSchemeId.equalsIgnoreCase(text)) {
                return openBankingSchemeId;
            }
        }
        return null;
    }
}
