package com.customate.client.models;

import com.customate.client.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models a politically-exposed person (PEP) and sanctions verification (request).
 *
 * Date: 25-Oct-23
 * Time: 4:13 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class VerificationPepSanctionsRequest extends BaseModel {

    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("middle_name")
    private String middleName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("birth_date")
    private String birthDate;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("passport")
    private Passport passport;

    /**
     * Default constructor.
     */
    public VerificationPepSanctionsRequest() { }

    /**
     * Constructor.
     *
     * @param firstName  First name.
     * @param middleName  Middle name.
     * @param lastName  Last name.
     * @param birthDate  Date of birth.
     * @param address  Address.
     * @param passport  Passport.
     */
    public VerificationPepSanctionsRequest(String firstName, String middleName, String lastName,
                                           String birthDate, Address address, Passport passport) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.passport = passport;
    }

}
