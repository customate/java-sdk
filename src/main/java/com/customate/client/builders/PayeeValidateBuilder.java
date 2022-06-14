package com.customate.client.builders;

import com.customate.client.models.PayeeUpdate;
import com.customate.client.models.PayeeUpdateRecipient;
import com.customate.client.models.PayeeValidate;
import com.customate.client.models.PayeeValidateRecipient;

/**
 * Builds a payee for validation.
 *
 * Date: 14-Jun-22
 * Time: 2:41 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class PayeeValidateBuilder {

    private String title;
    private PayeeValidateRecipient payeeValidateRecipient;

    /**
     * Sets the title.
     *
     * @param title  Title.
     * @return PayeeValidateBuilder  Updated payee builder (for validation).
     */
    public PayeeValidateBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Sets the payer.
     *
     * @param payeeValidateRecipient  Payee recipient (for validation).
     * @return PayeeValidateBuilder  Updated payee builder (for validation).
     */
    public PayeeValidateBuilder setPayeeValidateRecipient(PayeeValidateRecipient payeeValidateRecipient) {
        this.payeeValidateRecipient = payeeValidateRecipient;
        return this;
    }

    /**
     * Builds a payee (for validation).
     *
     * @return PayeeValidate  The payee.
     */
    public PayeeValidate build() {
        return new PayeeValidate(title, payeeValidateRecipient);
    }
}
