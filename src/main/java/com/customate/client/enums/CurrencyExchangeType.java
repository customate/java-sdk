package com.customate.client.enums;

/**
 * Enumeration of currency types.
 * 
 * Date: 12-Sep-22
 * Time: 1:58 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public enum CurrencyExchangeType {
    forex("forex"),
    p2p("p2p");

    private String currencyExchangeType;

    /**
     * Constructor.
     *
     * @param currencyExchangeType  The currency exchange type as a string.
     */
    CurrencyExchangeType(String currencyExchangeType) {
        this.currencyExchangeType = currencyExchangeType;
    }

    /**
     * Returns the currency exchange type as a string.
     */
    @Override
    public String toString() {
        return currencyExchangeType;
    }

    /**
     * Gets the currency exchange type from the input string.
     *
     * @param text  Currency exchange type to find.
     * @return CurrencyExchangeType  The currency exchange type found.
     */
    public static CurrencyExchangeType fromString(String text) {
        for (CurrencyExchangeType currencyExchangeType : CurrencyExchangeType.values()) {
            if (currencyExchangeType.currencyExchangeType.equalsIgnoreCase(text)) {
                return currencyExchangeType;
            }
        }
        return null;
    }
}
