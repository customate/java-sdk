package com.customate.client.builders;

import com.customate.client.enums.Gender;
import com.customate.client.enums.ProfileType;
import com.customate.client.enums.Title;
import com.customate.client.models.Address;
import com.customate.client.models.Profile;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Builds a profile.
 *
 * Date: 09-Feb-21
 * Time: 2:45 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class ProfileBuilder {

    private ProfileType type;
    private Title title;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String birthDate;
    private Address address;
    private Gender gender;
    private JsonNode metadata;

    /**
     * Sets the type (personal, business).
     *
     * @param type  Profile type.
     * @return ProfileBuilder  Updated profile builder.
     */
    public ProfileBuilder setType(ProfileType type) {
        this.type = type;
        return this;
    }

    /**
     * Sets the title (mr, mrs, miss, ms, other).
     *
     * @param title  Title (mr, mrs, miss, ms, other).
     * @return ProfileBuilder  Updated profile builder.
     */
    public ProfileBuilder setTitle(Title title) {
        this.title = title;
        return this;
    }

    /**
     * Sets the first name.
     *
     * @param firstName  Forename.
     * @return ProfileBuilder  Updated profile builder.
     */
    public ProfileBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Sets the middle name.
     *
     * @param middleName  Middle name.
     * @return ProfileBuilder  Updated profile builder.
     */
    public ProfileBuilder setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    /**
     * Sets the last name.
     *
     * @param lastName  Surname.
     * @return ProfileBuilder  Updated profile builder.
     */
    public ProfileBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Sets the email address (must be unique in the system).
     *
     * @param email  Email address (must be unique in the system).
     * @return ProfileBuilder  Updated profile builder.
     */
    public ProfileBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * Sets the phone number (international format, e.g. +447917654352 - must be unique in the system).
     *
     * @param phoneNumber  Phone number (international format, e.g. +447917654352 - must be unique in the system).
     * @return ProfileBuilder  Updated profile builder.
     */
    public ProfileBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    /**
     * Sets the birth date (YYYY-MM-DD format).
     *
     * @param birthDate  Date of birth (YYYY-MM-DD format).
     * @return ProfileBuilder  Updated profile builder.
     */
    public ProfileBuilder setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    /**
     * Sets the address.
     *
     * @param address  Address.
     * @return ProfileBuilder  Updated profile builder.
     */
    public ProfileBuilder setAddress(Address address) {
        this.address = address;
        return this;
    }

    /**
     * Sets the gender (male, female, other).
     *
     * @param gender  Gender (male, female, other).
     * @return ProfileBuilder  Updated profile builder.
     */
    public ProfileBuilder setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    /**
     * Sets the metadata (JSON node).
     *
     * @param metadata  Metadata.
     * @return ProfileBuilder  Updated profile builder.
     */
    public ProfileBuilder setMetadata(JsonNode metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Builds a profile.
     *
     * @return Profile  The profile.
     */
    public Profile build() {
        return new Profile(type, title, firstName, middleName, lastName, email,
                            phoneNumber, birthDate, address, gender, metadata);
    }
}
