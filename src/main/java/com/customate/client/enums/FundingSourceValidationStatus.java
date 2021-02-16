package com.customate.client.enums;

import java.util.List;

/**
 * Enumeration of funding source validation status.
 * 
 * Date: 11-Feb-21
 * Time: 4:20 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public enum FundingSourceValidationStatus {
    not_validated("not_validated"),
    pending("pending"),
    valid("valid"),
    invalid("invalid");

    private String fundingSourceValidationStatus;

    /**
     * Constructor.
     *
     * @param fundingSourceValidationStatus  The funding source validation status as a string.
     */
    FundingSourceValidationStatus(String fundingSourceValidationStatus) {
        this.fundingSourceValidationStatus = fundingSourceValidationStatus;
    }

    /**
     * Returns the funding source validation status as a string.
     */
    @Override
    public String toString() {
        return fundingSourceValidationStatus;
    }

    /**
     * Gets the funding source validation status from the input string.
     *
     * @param text  FundingSourceValidationStatus to find.
     * @return FundingSourceValidationStatus  The funding source validation status found.
     */
    public static FundingSourceValidationStatus fromString(String text) {
        for (FundingSourceValidationStatus fundingSourceValidationStatus : FundingSourceValidationStatus.values()) {
            if (fundingSourceValidationStatus.fundingSourceValidationStatus.equalsIgnoreCase(text)) {
                return fundingSourceValidationStatus;
            }
        }
        return null;
    }
}
