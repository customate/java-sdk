package com.customate.client.enums;

/**
 * Enumeration of currency exchange status.
 * 
 * Date: 10-Aug-22
 * Time: 5:48 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public enum CurrencyExchangeStatus {
    pending("pending"),
    processing("processing"),
    success("success"),
    failed("failed"),
    refund("refund"),
    canceled("canceled");

    private String currencyExchangeStatus;

    /**
     * Constructor.
     *
     * @param currencyExchangeStatus  The currency exchange status name as a string.
     */
    CurrencyExchangeStatus(String currencyExchangeStatus) {
        this.currencyExchangeStatus = currencyExchangeStatus;
    }

    /**
     * Returns the currency exchange status as a string.
     */
    @Override
    public String toString() {
        return currencyExchangeStatus;
    }

    /**
     * Gets the currency exchange status from the input string.
     *
     * @param text  CurrencyExchangeStatus to find.
     * @return CurrencyExchangeStatus  The currency exchange status found.
     */
    public static CurrencyExchangeStatus fromString(String text) {
        for (CurrencyExchangeStatus currencyExchangeStatus : CurrencyExchangeStatus.values()) {
            if (currencyExchangeStatus.currencyExchangeStatus.equalsIgnoreCase(text)) {
                return currencyExchangeStatus;
            }
        }
        return null;
    }

}

