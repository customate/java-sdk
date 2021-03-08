package com.customate.client.builders;

import com.customate.client.enums.Currency;
import com.customate.client.enums.PayeeType;
import com.customate.client.models.PayeeCreate;
import com.customate.client.models.PayeeCreateData;

/**
 * Builds a payee.
 *
 * Date: 26-Feb-21
 * Time: 1:10 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class PayeeBuilder {

    private String title;
    private PayeeType payeeType;
    private Currency currency;
    private PayeeCreateData payeeCreateData;

    /**
     * Sets the title (name).
     *
     * @param title  The title (name).
     * @return PayeeBuilder  Updated payee builder.
     */
    public PayeeBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Sets the payee type.
     *
     * @param payeeType  Payee type.
     * @return PayeeBuilder  Updated payee builder.
     */
    public PayeeBuilder setPayeeType(PayeeType payeeType) {
        this.payeeType = payeeType;
        return this;
    }

    /**
     * Sets the currency.
     *
     * @param currency  Currency.
     * @return PayeeBuilder  Updated payee builder.
     */
    public PayeeBuilder setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Sets the payee data (for creation).
     *
     * @param payeeCreateData  Payee create data.
     * @return PayeeBuilder  Updated payee builder.
     */
    public PayeeBuilder setPayeeCreateData(PayeeCreateData payeeCreateData) {
        this.payeeCreateData = payeeCreateData;
        return this;
    }

    /**
     * Builds a payee (for creation).
     *
     * @return PayeeCreate  The payee.
     */
    public PayeeCreate build() {
        return new PayeeCreate(title, payeeType, currency, payeeCreateData);
    }

}
