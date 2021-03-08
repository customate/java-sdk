package com.customate.client.enums;

/**
 * Enumeration of transaction names.
 *
 * Date: 15-Feb-21
 * Time: 2:46 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public enum TransactionName {
    LockTransferAndFeeAmount("LockTransferAndFeeAmount"),
    LockFeeAmount("LockFeeAmount"),
    Release("Release"),
    Refund("Refund"),
    IncomingContribution("IncomingContribution"),
    IncomingInternal("IncomingInternal"),
    OutgoingInternal("OutgoingInternal"),
    WalletToVirtualWallet("WalletToVirtualWallet"),
    VirtualWalletToWallet("VirtualWalletToWallet"),
    IbanToWallet("IbanToWallet"),
    WalletToIban("WalletToIban"),
    CreditCardToWallet("CreditCardToWallet"),
    CreditCardToVirtualWallet("CreditCardToVirtualWallet"),
    DirectDebitToWallet("DirectDebitToWallet"),
    DirectDebitToVirtualWallet("DirectDebitToVirtualWallet"),
    IncomingTax("IncomingTax"),
    IncomingFee("IncomingFee"),
    InternalFeeAndTax("InternalFeeAndTax"),
    MoneyInBtFeeAndTax("MoneyInBtFeeAndTax"),
    MoneyInCcFeeAndTax("MoneyInCcFeeAndTax"),
    MoneyInDdFeeAndTax("MoneyInDdFeeAndTax"),
    MoneyOutBtFeeAndTax("MoneyOutBtFeeAndTax"),
    OpenBankingToWallet("OpenBankingToWallet"),
    MoneyInObFeeAndTax("MoneyInObFeeAndTax"),
    External("External");

    private String transactionName;

    /**
     * Constructor.
     *
     * @param transactionName  The transaction name as a string.
     */
    TransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    /**
     * Returns the transaction name as a string.
     */
    @Override
    public String toString() {
        return transactionName;
    }

    /**
     * Gets the transaction name from the input string.
     *
     * @param text  TransactionName to find.
     * @return TransactionName  The transaction name found.
     */
    public static TransactionName fromString(String text) {
        for (TransactionName transactionName : TransactionName.values()) {
            if (transactionName.transactionName.equalsIgnoreCase(text)) {
                return transactionName;
            }
        }
        return null;
    }
}
