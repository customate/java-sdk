package com.customate.client.builders;

import com.customate.client.models.PayeeAccount;
import com.customate.client.models.PayeeCreateData;
import com.customate.client.models.Recipient;

/**
 * Builds payee data.
 *
 * Date: 26-Feb-21
 * Time: 1:28 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class PayeeDataBuilder {

    private Recipient recipient;
    private PayeeAccount payeeAccount;

    /**
     * Sets the recipient.
     *
     * @param recipient  Recipient.
     * @return PayeeDataBuilder  Updated payee data builder.
     */
    public PayeeDataBuilder setRecipient(Recipient recipient) {
        this.recipient = recipient;
        return this;
    }

    /**
     * Sets the payee account.
     *
     * @param payeeAccount  Payee account.
     * @return PayeeDataBuilder  Updated payee data builder.
     */
    public PayeeDataBuilder setPayeeAccount(PayeeAccount payeeAccount) {
        this.payeeAccount = payeeAccount;
        return this;
    }

    /**
     * Builds the payee data (for creation).
     *
     * @return PayeeCreateData  The payee data.
     */
    public PayeeCreateData build() {
        return new PayeeCreateData(recipient, payeeAccount);
    }

}
