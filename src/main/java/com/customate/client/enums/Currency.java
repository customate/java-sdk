package com.customate.client.enums;

/**
 * Enumeration of currencies.
 * 
 * Date: 11-Feb-21
 * Time: 3:04 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public enum Currency {
    GBP("GBP"),
    EUR("EUR");
    
    private String currency;

    /**
     * Constructor.
     *
     * @param currency  The currency as a string.
     */
    Currency(String currency) {
        this.currency = currency;
    }

    /**
     * Returns the currency as a string.
     */
    @Override
    public String toString() {
        return currency;
    }

    /**
     * Gets the currency from the input string.
     *
     * @param text  Currency to find.
     * @return Currency  The currency found.
     */
    public static Currency fromString(String text) {
        for (Currency currency : Currency.values()) {
            if (currency.currency.equalsIgnoreCase(text)) {
                return currency;
            }
        }
        return null;
    }
}
