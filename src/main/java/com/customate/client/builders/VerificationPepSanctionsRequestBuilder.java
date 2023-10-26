package com.customate.client.builders;

import com.customate.client.models.*;

/**
 * Builds a verification request - politically-exposed persons & sanctions - without a profile.
 *
 * Date: 25-Oct-23
 * Time: 5:20 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class VerificationPepSanctionsRequestBuilder {

    private String firstName;
    private String middleName;
    private String lastName;
    private String birthDate;
    private Address address;
    private Passport passport;

    /**
     * Sets the first name.
     *
     * @param firstName  Forename.
     * @return VerificationPepSanctionsRequestBuilder  Updated politically-exposed persons & sanctions (no profile) builder.
     */
    public VerificationPepSanctionsRequestBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Sets the middle name.
     *
     * @param middleName  Middle name.
     * @return VerificationPepSanctionsRequestBuilder  Updated politically-exposed persons & sanctions (no profile) builder.
     */
    public VerificationPepSanctionsRequestBuilder setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    /**
     * Sets the last name.
     *
     * @param lastName  Surname.
     * @return VerificationPepSanctionsRequestBuilder  Updated politically-exposed persons & sanctions (no profile) builder.
     */
    public VerificationPepSanctionsRequestBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Sets the birth date (YYYY-MM-DD format).
     *
     * @param birthDate  Date of birth (YYYY-MM-DD format).
     * @return VerificationPepSanctionsRequestBuilder  Updated politically-exposed persons & sanctions (no profile) builder.
     */
    public VerificationPepSanctionsRequestBuilder setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    /**
     * Sets the address.
     *
     * @param address  Address.
     * @return VerificationPepSanctionsRequestBuilder  Updated politically-exposed persons & sanctions (no profile) builder.
     */
    public VerificationPepSanctionsRequestBuilder setAddress(Address address) {
        this.address = address;
        return this;
    }

    /**
     * Sets the passport.
     *
     * @param passport  Passport.
     * @return VerificationRequestBuilder  Updated politically-exposed persons & sanctions verification (no profile) builder.
     */
    public VerificationPepSanctionsRequestBuilder setPassport(Passport passport) {
        this.passport = passport;
        return this;
    }

    /**
     * Builds a politically-exposed persons & sanctions verification request.
     *
     * @return VerificationNoProfileRequest  The politically-exposed persons & sanctions verification request (no profile).
     */
    public VerificationPepSanctionsRequest build() {
        return new VerificationPepSanctionsRequest(firstName, middleName, lastName, birthDate, address, passport);
    }

}
