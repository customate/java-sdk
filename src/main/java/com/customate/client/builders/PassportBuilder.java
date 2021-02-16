package com.customate.client.builders;

import com.customate.client.models.Passport;

/**
 * Builds a passport.
 *
 * Date: 10-Feb-21
 * Time: 2:03 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class PassportBuilder {

    private String originCountry;
    private String number;
    private String expiryDate;

    /**
     * Sets the passport country of origin.
     *
     * @param originCountry  Country of origin (2-digit ISO country code).
     * @return PassportBuilder  Updated passport builder.
     */
    public PassportBuilder setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
        return this;
    }

    /**
     * Sets the passport number.
     *
     * @param number  Passport number.
     * @return PassportBuilder  Updated passport builder.
     */
    public PassportBuilder setNumber(String number) {
        this.number = number;
        return this;
    }

    /**
     * Sets the expiry date (in YYYY-MM-DD format).
     *
     * @param expiryDate  Expiry date in YYYY-MM-DD format.
     * @return PassportBuilder  Updated passport builder.
     */
    public PassportBuilder setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
        return this;
    }

    /**
     * Builds a passport.
     *
     * @return Passport  The passport.
     */
    public Passport build() {
        return new Passport(originCountry, number, expiryDate);
    }
}
