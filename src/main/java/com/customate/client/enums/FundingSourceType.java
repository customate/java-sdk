package com.customate.client.enums;

import java.util.List;

/**
 * Enumeration of funding source types.
 * 
 * Date: 11-Feb-21
 * Time: 4:20 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public enum FundingSourceType {

    direct_debit("direct_debit"),
    wallet("wallet"),
    virtual_wallet("virtual_wallet"),
    credit_card("credit_card"),
    open_banking("open_banking");

    public static final List<FundingSourceType> WALLET_TYPES = List.of(wallet, virtual_wallet, open_banking);

    private String fundingSourceType;

    /**
     * Constructor.
     *
     * @param fundingSourceType  The funding source type as a string.
     */
    FundingSourceType(String fundingSourceType) {
        this.fundingSourceType = fundingSourceType;
    }

    /**
     * Returns the funding source type as a string.
     */
    @Override
    public String toString() {
        return fundingSourceType;
    }

    /**
     * Gets the funding source type from the input string.
     *
     * @param text  FundingSourceType to find.
     * @return FundingSourceType  The funding source type found.
     */
    public static FundingSourceType fromString(String text) {
        for (FundingSourceType type : FundingSourceType.values()) {
            if (type.fundingSourceType.equalsIgnoreCase(text)) {
                return type;
            }
        }
        return null;
    }
}
