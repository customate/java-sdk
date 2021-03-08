package com.customate.client.enums;

/**
 * Enumeration of payment status.
 * 
 * Date: 02-Mar-21
 * Time: 2:45 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public enum OpenBankingPaymentStatus {
    PENDING("PENDING"),
    PROCESSING("PROCESSING"),
    SUCCESS("SUCCESS"),
    FAILED("FAILED"),
    REFUND("REFUND"),
    CANCELED("CANCELED");

    private String paymentStatus;

    /**
     * Constructor.
     *
     * @param paymentStatus  The payment name as a string.
     */
    OpenBankingPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    /**
     * Returns the payment status as a string.
     */
    @Override
    public String toString() {
        return paymentStatus;
    }

    /**
     * Gets the payment status from the input string.
     *
     * @param text  PaymentStatus to find.
     * @return PaymentStatus  The payment status found.
     */
    public static OpenBankingPaymentStatus fromString(String text) {
        for (OpenBankingPaymentStatus paymentStatus : OpenBankingPaymentStatus.values()) {
            if (paymentStatus.paymentStatus.equalsIgnoreCase(text)) {
                return paymentStatus;
            }
        }
        return null;
    }

}

