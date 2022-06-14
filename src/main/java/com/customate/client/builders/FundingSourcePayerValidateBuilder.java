package com.customate.client.builders;

import com.customate.client.models.FundingSourceAddress;
import com.customate.client.models.FundingSourceValidatePayer;
import com.customate.client.models.PayeeAddress;
import com.customate.client.models.PayeeValidateRecipient;

/**
 * Builds a payer for validating a funding source.
 *
 * Date: 14-Jun-22
 * Time: 3:00 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class FundingSourcePayerValidateBuilder {

    private String firstName;
    private String lastName;
    private String birthDate;
    private String email;
    private FundingSourceAddress fundingSourceAddress;

    /**
     * Sets the first name.
     *
     * @param firstName  Forename.
     * @return FundingSourcePayerValidateBuilder  Updated funding source payer validate builder.
     */
    public FundingSourcePayerValidateBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Sets the last name.
     *
     * @param lastName  Surname.
     * @return FundingSourcePayerValidateBuilder  Updated funding source payer validate builder.
     */
    public FundingSourcePayerValidateBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Sets the date of birth.
     *
     * @param birthDate  birthDate.
     * @return FundingSourcePayerValidateBuilder  Updated funding source payer validate builder.
     */
    public FundingSourcePayerValidateBuilder setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    /**
     * Sets the email.
     *
     * @param email  Email.
     * @return FundingSourcePayerValidateBuilder  Updated funding source payer validate builder.
     */
    public FundingSourcePayerValidateBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * Sets the funding source address.
     *
     * @param fundingSourceAddress  Funding source address.
     * @return FundingSourcePayerValidateBuilder  Updated funding source payer validate builder.
     */
    public FundingSourcePayerValidateBuilder setFundingSourceAddress(FundingSourceAddress fundingSourceAddress) {
        this.fundingSourceAddress = fundingSourceAddress;
        return this;
    }

    /**
     * Builds a funding source payer for validation.
     *
     * @return FundingSourceValidateRecipient  Updated payee recipient (for validation) builder.
     */
    public FundingSourceValidatePayer build() {
        return new FundingSourceValidatePayer(firstName, lastName, birthDate, email, fundingSourceAddress);
    }
}
