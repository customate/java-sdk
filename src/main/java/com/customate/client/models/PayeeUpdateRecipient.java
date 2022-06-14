package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models a payee recipient (for update).
 *
 * Date: 13-Jun-22
 * Time: 4:14 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PayeeUpdateRecipient extends BaseModel {

    @JsonProperty("email")
    private String email;

    @JsonProperty("address")
    private PayeeAddress payeeAddress;

    /**
     * Default constructor.
     */
    public PayeeUpdateRecipient() { }

    /**
     * Constructor.
     *
     * @param email  email.
     * @param payeeAddress  Payee address.
     */
    public PayeeUpdateRecipient(String email, PayeeAddress payeeAddress) {
        this.email = email;
        this.payeeAddress = payeeAddress;
    }
}
