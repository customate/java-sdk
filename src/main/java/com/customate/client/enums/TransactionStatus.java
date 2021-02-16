package com.customate.client.enums;

/**
 * Enumeration of transaction status.
 *
 * Date: 15-Feb-21
 * Time: 2:57 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public enum TransactionStatus {
    pending("pending"),
    processing("processing"),
    success("success"),
    failed("failed"),
    refund("refund"),
    canceled("canceled");

    private String transactionStatus;

    /**
     * Constructor.
     *
     * @param transactionStatus  The transaction name as a string.
     */
    TransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    /**
     * Returns the transaction status as a string.
     */
    @Override
    public String toString() {
        return transactionStatus;
    }

    /**
     * Gets the transaction status from the input string.
     *
     * @param text  TransactionStatus to find.
     * @return TransactionStatus  The transaction status found.
     */
    public static TransactionStatus fromString(String text) {
        for (TransactionStatus status : TransactionStatus.values()) {
            if (status.transactionStatus.equalsIgnoreCase(text)) {
                return status;
            }
        }
        return null;
    }
}
