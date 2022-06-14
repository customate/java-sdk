package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models a payee recipient (for validation).
 *
 * Date: 14-Jun-22
 * Time: 2:27 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PayeeValidateRecipient extends BaseModel {

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("birth_date")
    private String birthDate;

    @JsonProperty("email")
    private String email;

    @JsonProperty("address")
    private PayeeAddress payeeAddress;

    /**
     * Default constructor.
     */
    public PayeeValidateRecipient() {
    }

    /**
     * Constructor.
     *
     * @param firstName    Forename.
     * @param lastName     Surname.
     * @param birthDate    Date of birth.
     * @param email        Email address.
     * @param payeeAddress Payee address.
     */
    public PayeeValidateRecipient(String firstName, String lastName, String birthDate, String email, PayeeAddress payeeAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.payeeAddress = payeeAddress;
    }
}