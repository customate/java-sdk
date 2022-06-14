package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Models a payee (used on update).
 * 
 * Date: 13-Jun-22
 * Time: 12:47 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class PayeeUpdate extends BaseModel {

    @JsonProperty("title")
    private String title;
    @JsonProperty("recipient")
    private PayeeUpdateRecipient payeeUpdateRecipient;

    /**
     * Default constructor.
     */
    public PayeeUpdate() { }

    /**
     * Constructor.
     *
     * @param title  Title.
     * @param payeeUpdateRecipient  Payee recipient for update.
     */
    public PayeeUpdate(String title, PayeeUpdateRecipient payeeUpdateRecipient) {
        this.title = title;
        this.payeeUpdateRecipient = payeeUpdateRecipient;
    }
}
