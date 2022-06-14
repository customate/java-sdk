package com.customate.client.builders;

import com.customate.client.models.PayeeAddress;
import com.customate.client.models.PayeeUpdateRecipient;
import com.customate.client.models.PayeeValidateRecipient;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Builds a recipient for validating a payee.
 *
 * Date: 14-Jun-22
 * Time: 14:32 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class PayeeRecipientValidateBuilder {

    private String firstName;
    private String lastName;
    private String birthDate;
    private String email;
    private PayeeAddress payeeAddress;

    /**
     * Sets the first name.
     *
     * @param firstName  Forename.
     * @return PayeeRecipientValidateBuilder  Updated payee recipient validate builder.
     */
    public PayeeRecipientValidateBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Sets the last name.
     *
     * @param lastName  Surname.
     * @return PayeeRecipientValidateBuilder  Updated payee recipient validate builder.
     */
    public PayeeRecipientValidateBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Sets the date of birth.
     *
     * @param birthDate  birthDate.
     * @return PayeeRecipientValidateBuilder  Updated payee recipient validate builder.
     */
    public PayeeRecipientValidateBuilder setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    /**
     * Sets the email.
     *
     * @param email  Email.
     * @return PayeeRecipientValidateBuilder  Updated payee recipient validate builder.
     */
    public PayeeRecipientValidateBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * Sets the funding source address.
     *
     * @param payeeAddress  Funding source address.
     * @return PayeeRecipientValidateBuilder  Updated payee recipient validate builder.
     */
    public PayeeRecipientValidateBuilder setPayeeAddress(PayeeAddress payeeAddress) {
        this.payeeAddress = payeeAddress;
        return this;
    }

    /**
     * Builds a funding source payer for validation.
     *
     * @return PayeeValidateRecipient  Updated payee recipient validate builder.
     */
    public PayeeValidateRecipient build() {
        return new PayeeValidateRecipient(firstName, lastName, birthDate, email, payeeAddress);
    }
}
