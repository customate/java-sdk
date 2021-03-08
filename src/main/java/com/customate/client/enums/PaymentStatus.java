package com.customate.client.enums;

/**
 * Enumeration of payment status.
 * 
 * Date: 01-Mar-21
 * Time: 4:20 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public enum PaymentStatus {
    pending("pending"),
    processing("processing"),
    success("success"),
    failed("failed"),
    refund("refund"),
    canceled("canceled");

    private String paymentStatus;

    /**
     * Constructor.
     *
     * @param paymentStatus  The payment name as a string.
     */
    PaymentStatus(String paymentStatus) {
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
    public static PaymentStatus fromString(String text) {
        for (PaymentStatus paymentStatus : PaymentStatus.values()) {
            if (paymentStatus.paymentStatus.equalsIgnoreCase(text)) {
                return paymentStatus;
            }
        }
        return null;
    }

}

