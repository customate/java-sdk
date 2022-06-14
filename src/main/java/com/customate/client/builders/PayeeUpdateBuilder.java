package com.customate.client.builders;

import com.customate.client.models.FundingSourceUpdate;
import com.customate.client.models.FundingSourceUpdatePayer;
import com.customate.client.models.PayeeUpdate;
import com.customate.client.models.PayeeUpdateRecipient;

/**
 * Builds a payee for update.
 *
 * Date: 13-Jun-22
 * Time: 16:19 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class PayeeUpdateBuilder {

    private String title;
    private PayeeUpdateRecipient payeeUpdateRecipient;

    /**
     * Sets the title.
     *
     * @param title  Title.
     * @return PayeeUpdateBuilder  Updated payee builder.
     */
    public PayeeUpdateBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Sets the payer.
     *
     * @param payeeUpdateRecipient  Payee recipient (for update).
     * @return PayeeUpdateBuilder  Updated funding source builder.
     */
    public PayeeUpdateBuilder setPayeeUpdateRecipient(PayeeUpdateRecipient payeeUpdateRecipient) {
        this.payeeUpdateRecipient = payeeUpdateRecipient;
        return this;
    }

    /**
     * Builds a payee (for update).
     *
     * @return PayeeUpdate  The payee.
     */
    public PayeeUpdate build() {
        return new PayeeUpdate(title, payeeUpdateRecipient);
    }
}
