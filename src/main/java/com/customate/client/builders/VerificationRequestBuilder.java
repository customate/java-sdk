package com.customate.client.builders;

import com.customate.client.models.*;

/**
 * Builds a verification request.
 *
 * Date: 09-Feb-21
 * Time: 2:45 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class VerificationRequestBuilder {

    private String birthCountry;
    private String motherMaidenName;
    private Passport passport;
    private DriverLicence driverLicence;

    /**
     * Sets the country of birth (2-digit ISO country code).
     *
     * @param birthCountry  Country of birth (2-digit ISO country code).
     * @return VerificationRequestBuilder  Updated verification request builder.
     */
    public VerificationRequestBuilder setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
        return this;
    }

    /**
     * Sets the mother's maiden name.
     *
     * @param motherMaidenName  Mother's maiden name.
     * @return VerificationRequestBuilder  Updated verification request builder.
     */
    public VerificationRequestBuilder setMotherMaidenName(String motherMaidenName) {
        this.motherMaidenName = motherMaidenName;
        return this;
    }

    /**
     * Sets the passport.
     *
     * @param passport  Passport.
     * @return VerificationRequestBuilder  Updated verification request builder.
     */
    public VerificationRequestBuilder setPassport(Passport passport) {
        this.passport = passport;
        return this;
    }

    /**
     * Sets the driving licence.
     *
     * @param driverLicence  Driving licence.
     * @return VerificationRequestBuilder  Updated verification request builder.
     */
    public VerificationRequestBuilder setDriverLicence(DriverLicence driverLicence) {
        this.driverLicence = driverLicence;
        return this;
    }

    /**
     * Builds a verification request.
     *
     * @return VerificationRequest  The verification request.
     */
    public VerificationRequest build() {
        return new VerificationRequest(birthCountry, motherMaidenName, passport, driverLicence);
    }
}
