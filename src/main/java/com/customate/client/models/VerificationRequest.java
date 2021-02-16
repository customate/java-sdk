package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models a profile verification (request).
 *
 * Date: 10-Feb-21
 * Time: 12:31 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class VerificationRequest extends BaseModel {

    /**
     * 2-digit ISO country code.
     */
    @JsonProperty("birth_country")
    private String birthCountry;
    @JsonProperty("mother_maiden_name")
    private String motherMaidenName;
    @JsonProperty("passport")
    private Passport passport;
    @JsonProperty("driver_licence")
    private DriverLicence driverLicence;

    /**
     * Default constructor.
     */
    public VerificationRequest() { }

    /**
     * Constructor.
     *
     * @param birthCountry  Country of birth, 2-digit ISO country code.
     * @param motherMaidenName  Mother's maiden name.
     * @param passport  Passport.
     * @param driverLicence  Driver's licence.
     */
    public VerificationRequest(String birthCountry, String motherMaidenName, Passport passport, DriverLicence driverLicence) {
        this.birthCountry = birthCountry;
        this.motherMaidenName = motherMaidenName;
        this.passport = passport;
        this.driverLicence = driverLicence;
    }

}
