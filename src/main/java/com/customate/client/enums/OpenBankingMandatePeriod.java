package com.customate.client.enums;

/**
 * Enumeration of open banking mandate periods.
 * 
 * Date: 18-Jan-23
 * Time: 2:53 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public enum OpenBankingMandatePeriod {

    Daily("Daily"),
    Weekly("Weekly"),
    Monthly("Monthly"),
    Quarterly("Biannually"),
    Yearly("Yearly");

    private String openBankingMandatePeriod;

    /**
     * Constructor.
     *
     * @param openBankingMandatePeriod  The open banking mandate period as a string.
     */
    OpenBankingMandatePeriod(String openBankingMandatePeriod) {
        this.openBankingMandatePeriod = openBankingMandatePeriod;
    }

    /**
     * Returns the open banking mandate period as a string.
     */
    @Override
    public String toString() {
        return openBankingMandatePeriod;
    }

    /**
     * Gets the open banking mandate period from the input string.
     *
     * @param text  OpenBankingMandatePeriod to find.
     * @return OpenBankingMandatePeriod  The open banking mandate period found.
     */
    public static OpenBankingMandatePeriod fromString(String text) {
        for (OpenBankingMandatePeriod openBankingMandatePeriod : OpenBankingMandatePeriod.values()) {
            if (openBankingMandatePeriod.openBankingMandatePeriod.equalsIgnoreCase(text)) {
                return openBankingMandatePeriod;
            }
        }
        return null;
    }

}
