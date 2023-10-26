package com.customate.client.models;

import com.customate.client.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models a verification without a profile (request).
 *
 * Date: 25-Oct-23
 * Time: 4:12 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class VerificationNoProfileRequest extends BaseModel {

    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("middle_name")
    private String middleName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("gender")
    private Gender gender;
    @JsonProperty("birth_date")
    private String birthDate;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("passport")
    private Passport passport;
    @JsonProperty("driver_licence")
    private DriverLicence driverLicence;
    @JsonProperty("identity_card")
    private IdentityCard identityCard;
    @JsonProperty("tax_id_number")
    private String taxIdNumber;

    /**
     * Default constructor.
     */
    public VerificationNoProfileRequest() { }

    /**
     * Constructor.
     *
     * @param firstName  First name.
     * @param middleName  Middle name.
     * @param lastName  Last name.
     * @param gender  Gender.
     * @param birthDate  Date of birth.
     * @param address  Address.
     * @param passport  Passport.
     * @param driverLicence  Driver's licence.
     * @param identityCard  Identity card.
     * @param taxIdNumber  Tax ID number.
     */
    public VerificationNoProfileRequest(String firstName, String middleName, String lastName, Gender gender,
                                        String birthDate, Address address, Passport passport,
                                        DriverLicence driverLicence, IdentityCard identityCard, String taxIdNumber) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.address = address;
        this.passport = passport;
        this.driverLicence = driverLicence;
        this.identityCard = identityCard;
        this.taxIdNumber = taxIdNumber;
    }

}
