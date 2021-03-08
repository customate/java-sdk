package com.customate.client.models;

import com.customate.client.enums.Currency;
import com.customate.client.enums.PayeeType;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Models a payee (used on creation).
 *
 * Date: 26-Feb-21
 * Time: 12:53 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class PayeeCreate extends BaseModel {

    @JsonProperty("title")
    private String title;
    @JsonProperty("type")
    private PayeeType payeeType;
    @JsonProperty("currency")
    private Currency currency;
    @JsonProperty("data")
    private PayeeCreateData payeeCreateData;

    /**
     * Default constructor.
     */
    public PayeeCreate() { }

    /**
     * Constructor.
     *
     * @param title  Payee name.
     * @param payeeType  Payee type.
     * @param currency  Currency.
     * @param payeeCreateData  Payee data for creation.
     */
    public PayeeCreate(String title, PayeeType payeeType, Currency currency, PayeeCreateData payeeCreateData) {
        this.title = title;
        this.payeeType = payeeType;
        this.currency = currency;
        this.payeeCreateData = payeeCreateData;
    }

}
