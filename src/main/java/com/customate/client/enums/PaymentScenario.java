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
    IncomingContribution("Override"),
    OutgoingInternal("OutgoingInternal"),
    OutgoingInternalFromVirtualWallet("OutgoingInternalFromVirtualWallet"),
    IncomingInternal("IncomingInternal"),
    WalletToVirtualWallet("WalletToVirtualWallet"),
    VirtualWalletToWallet("VirtualWalletToWallet"),
    External("External"),
    IncomingBankTransfer("IncomingBankTransfer"),
    CreditCardToWallet("CreditCardToWallet"),
    CreditCardToVirtualWallet("CreditCardToVirtualWallet"),
    CreditCardWithOutgoingInternal("CreditCardWithOutgoingInternal"),
    CreditCardToIban("CreditCardToIban"),
    IncomingDirectDebit("IncomingDirectDebit"),
    DirectDebitToVirtualWallet("DirectDebitToVirtualWallet"),
    DirectDebitToInternal("DirectDebitToInternal"),
    DirectDebitToExternal("DirectDebitToExternal"),
    IncomingFee("IncomingFee"),
    IncomingTax("IncomingTax"),
    OpenBankingToWallet("OpenBankingToWallet"),
    CurrencyExchangeFeeAndTax("CurrencyExchangeFeeAndTax"),
    OutgoingExchangeFromInitiator("OutgoingExchangeFromInitiator"), // Initiator sells currency A
    IncomingExchangeToCounterparty("IncomingExchangeToCounterparty"), // Counterparty receives currency A
    OutgoingExchangeFromCounterparty("OutgoingExchangeFromCounterparty"), // Counterparty sells currency B
    IncomingExchangeToInitiator("IncomingExchangeToInitiator"); // Initiator receives currency B

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
