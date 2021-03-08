package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models payee data (used on creation).
 *
 * Date: 26-Feb-21
 * Time: 12:58 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PayeeCreateData extends BaseModel {

    @JsonProperty("recipient")
    private Recipient recipient;
    @JsonProperty("account")
    private PayeeAccount payeeAccount;

    /**
     * Default constructor.
     */
    public PayeeCreateData() { }

    /**
     * Constructor.
     *
     * @param recipient  The recipient.
     * @param payeeAccount  The account.
     */
    public PayeeCreateData(Recipient recipient, PayeeAccount payeeAccount) {
        this.recipient = recipient;
        this.payeeAccount = payeeAccount;
    }

}
