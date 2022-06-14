package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Models a payee (used in validation).
 * 
 * Date: 14-Jun-22
 * Time: 2:30 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class PayeeValidate extends BaseModel {

    @JsonProperty("title")
    private String title;
    @JsonProperty("recipient")
    private PayeeValidateRecipient payeeValidateRecipient;

    /**
     * Default constructor.
     */
    public PayeeValidate() { }

    /**
     * Constructor.
     *
     * @param title  Title.
     * @param payeeValidateRecipient  Payee recipient for validation.
     */
    public PayeeValidate(String title, PayeeValidateRecipient payeeValidateRecipient) {
        this.title = title;
        this.payeeValidateRecipient = payeeValidateRecipient;
    }
}
