package com.customate.client.enums;

/**
 * Enumeration of open banking fee option IDs.
 * 
 * Date: 19-Apr-21
 * Time: 12:15 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public enum OpenBankingFeeOptionId {
    sepa_credit_transfer_instant_fee("sepa_credit_transfer_instant_fee");

    private String openBankingFeeOptionId;

    /**
     * Constructor.
     *
     * @param openBankingFeeOptionId  Open banking fee option ID as a string.
     */
    OpenBankingFeeOptionId(String openBankingFeeOptionId) {
        this.openBankingFeeOptionId = openBankingFeeOptionId;
    }

    /**
     * Returns the open banking fee option ID as a string.
     */
    @Override
    public String toString() {
        return openBankingFeeOptionId;
    }

    /**
     * Gets the open banking fee option ID from the input string.
     *
     * @param text  OpenBankingFeeOptionId to find.
     * @return OpenBankingFeeOptionId  The open banking fee option ID found.
     */
    public static OpenBankingFeeOptionId fromString(String text) {
        for (OpenBankingFeeOptionId openBankingFeeOptionId : OpenBankingFeeOptionId.values()) {
            if (openBankingFeeOptionId.openBankingFeeOptionId.equalsIgnoreCase(text)) {
                return openBankingFeeOptionId;
            }
        }
        return null;
    }
}
