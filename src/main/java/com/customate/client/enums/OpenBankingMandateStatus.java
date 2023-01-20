package com.customate.client.enums;

/**
 * Enumeration of open banking mandate status.
 * 
 * Date: 18-Jan-23
 * Time: 3:47 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public enum OpenBankingMandateStatus {
    authorization_required("authorization_required"),
    authorizing("authorizing"),
    mandate_authorized("mandate_authorized"),
    mandate_failed("mandate_failed"),
    mandate_revoked("mandate_revoked");

    private String status;

    OpenBankingMandateStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }

    public static OpenBankingMandateStatus fromString(String text) {
        for (OpenBankingMandateStatus openBankingMandateStatus : OpenBankingMandateStatus.values()) {
            if (openBankingMandateStatus.status.equalsIgnoreCase(text)) {
                return openBankingMandateStatus;
            }
        }

        return null;
    }

}