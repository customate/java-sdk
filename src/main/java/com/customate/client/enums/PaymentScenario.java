package com.customate.client.enums;

/**
 * Enumeration of payment scenarios.
 *
 * Date: 01-Mar-21
 * Time: 4:27 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public enum PaymentScenario {
    IncomingContribution("IncomingContribution"),
    OutgoingInternalFromWallet("OutgoingInternalFromWallet"),
    OutgoingInternalFromVirtualWallet("OutgoingInternalFromVirtualWallet"),
    IncomingInternal("IncomingInternal"),
    WalletToVirtualWallet("WalletToVirtualWallet"),
    VirtualWalletToWallet("VirtualWalletToWallet"),
    WalletToIban("WalletToIban"),
    IbanToWallet("IbanToWallet"),
    CreditCardToWallet("CreditCardToWallet"),
    CreditCardToVirtualWallet("CreditCardToVirtualWallet"),
    CreditCardWithOutgoingInternal("CreditCardWithOutgoingInternal"),
    CreditCardToIban("CreditCardToIban"),
    DirectDebitToWallet("DirectDebitToWallet"),
    DirectDebitToVirtualWallet("DirectDebitToVirtualWallet"),
    DirectDebitWithOutgoingInternal("DirectDebitWithOutgoingInternal"),
    DirectDebitToIban("DirectDebitToIban"),
    IncomingFee("IncomingFee"),
    IncomingTax("IncomingTax"),
    OpenBankingToWallet("OpenBankingToWallet"),
    External("External"),
    IncomingBankTransfer("IncomingBankTransfer");

    private String paymentScenario;

    /**
     * Constructor.
     *
     * @param paymentScenario  The payment scenario as a string.
     */
    PaymentScenario(String paymentScenario) {
        this.paymentScenario = paymentScenario;
    }

    /**
     * Returns the payment scenario as a string.
     */
    @Override
    public String toString() {
        return paymentScenario;
    }

    /**
     * Gets the payment scenario from the input string.
     *
     * @param text  PaymentScenario to find.
     * @return PaymentScenario  The payment scenario found.
     */
    public static PaymentScenario fromString(String text) {
        for (PaymentScenario paymentScenario : PaymentScenario.values()) {
            if (paymentScenario.paymentScenario.equalsIgnoreCase(text)) {
                return paymentScenario;
            }
        }
        return null;
    }

}
