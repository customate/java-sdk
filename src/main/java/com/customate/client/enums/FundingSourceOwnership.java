package com.customate.client.enums;

/**
 * Enumerates ownership in a funding source.
 *
 * Date: 12-Feb-21
 * Time: 12:47 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public enum FundingSourceOwnership {
    
    single("single"),
    joint("joint");

    private String fundingSourceOwnership;

    /**
     * Constructor.
     *
     * @param fundingSourceOwnership  Funding source ownership.
     */
    FundingSourceOwnership(String fundingSourceOwnership) {
        this.fundingSourceOwnership = fundingSourceOwnership;
    }

    /**
     * Returns the funding source ownership as a string.
     */
    @Override
    public String toString() {
        return fundingSourceOwnership;
    }

    /**
     * Gets the funding source ownership from the input string.
     *
     * @param text  FundingSourceOwnership to find.
     * @return FundingSourceOwnership  The funding source ownership found.
     */
    public static FundingSourceOwnership fromString(String text) {
        for (FundingSourceOwnership ownership : FundingSourceOwnership.values()) {
            if (ownership.fundingSourceOwnership.equalsIgnoreCase(text)) {
                return ownership;
            }
        }
        return null;
    }
}
