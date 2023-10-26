package com.customate.client.builders;

import com.customate.client.enums.Gender;
import com.customate.client.models.*;

/**
 * Builds a verification request - without a profile.
 *
 * Date: 25-Oct-23
 * Time: 4:42 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class VerificationNoProfileRequestBuilder {

    private String firstName;
    private String middleName;
    private String lastName;
    private Gender gender;
    private String birthDate;
    private Address address;
    private Passport passport;
    private DriverLicence driverLicence;
    private IdentityCard identityCard;
    private String taxIdNumber;

    /**
     * Sets the first name.
     *
     * @param firstName  Forename.
     * @return VerificationNoProfileRequestBuilder  Updated verification (no profile) builder.
     */
    public VerificationNoProfileRequestBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Sets the middle name.
     *
     * @param middleName  Middle name.
     * @return VerificationNoProfileRequestBuilder  Updated (no profile) builder.
     */
    public VerificationNoProfileRequestBuilder setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    /**
     * Sets the last name.
     *
     * @param lastName  Surname.
     * @return VerificationNoProfileRequestBuilder  Updated (no profile) builder.
     */
    public VerificationNoProfileRequestBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Sets the gender (male, female, other).
     *
     * @param gender  Gender (male, female, other).
     * @return VerificationNoProfileRequestBuilder  Updated (no profile) builder.
     */
    public VerificationNoProfileRequestBuilder setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    /**
     * Sets the birth date (YYYY-MM-DD format).
     *
     * @param birthDate  Date of birth (YYYY-MM-DD format).
     * @return VerificationNoProfileRequestBuilder  Updated (no profile) builder.
     */
    public VerificationNoProfileRequestBuilder setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    /**
     * Sets the address.
     *
     * @param address  Address.
     * @return VerificationNoProfileRequestBuilder  Updated (no profile) builder.
     */
    public VerificationNoProfileRequestBuilder setAddress(Address address) {
        this.address = address;
        return this;
    }

    /**
     * Sets the passport.
     *
     * @param passport  Passport.
     * @return VerificationRequestBuilder  Updated verification (no profile) builder.
     */
    public VerificationNoProfileRequestBuilder setPassport(Passport passport) {
        this.passport = passport;
        return this;
    }

    /**
     * Sets the driving licence.
     *
     * @param driverLicence  Driving licence.
     * @return VerificationRequestBuilder  Updated verification (no profile) builder.
     */
    public VerificationNoProfileRequestBuilder setDriverLicence(DriverLicence driverLicence) {
        this.driverLicence = driverLicence;
        return this;
    }

    /**
     * Sets the identity card.
     *
     * @param identityCard  Identity card.
     * @return VerificationNoProfileRequestBuilder  Updated (no profile) builder.
     */
    public VerificationNoProfileRequestBuilder setIdentityCard(IdentityCard identityCard) {
        this.identityCard = identityCard;
        return this;
    }

    /**
     * Sets the tax ID number.
     *
     * @param taxIdNumber  Tax ID number.
     * @return VerificationNoProfileRequestBuilder  Updated (no profile) builder.
     */
    public VerificationNoProfileRequestBuilder setTaxIdNumber(String taxIdNumber) {
        this.taxIdNumber = taxIdNumber;
        return this;
    }

    /**
     * Builds a verification request.
     *
     * @return VerificationNoProfileRequest  The verification request (no profile).
     */
    public VerificationNoProfileRequest build() {
        return new VerificationNoProfileRequest(firstName, middleName, lastName, gender, birthDate, address, passport,
                driverLicence, identityCard, taxIdNumber);
    }

}
