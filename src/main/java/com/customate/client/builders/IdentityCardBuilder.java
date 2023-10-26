package com.customate.client.builders;

import com.customate.client.models.IdentityCard;

/**
 * Builds an identity card.
 *
 * Date: 25-Oct-23
 * Time: 4:57 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class IdentityCardBuilder {

    private String number;
    private String country;

    /**
     * Sets number.
     *
     * @param number  ID card number.
     * @return IdentityCardBuilder  Updated identity card builder.
     */
    public IdentityCardBuilder setNumber(String number) {
        this.number = number;
        return this;
    }

    /**
     * Sets the country (2-digit ISO country code).
     *
     * @param country  Country.
     * @return IdentityCardBuilder  Updated identity card builder.
     */
    public IdentityCardBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    /**
     * Builds an identity card.
     *
     * @return IdentityCard  The identity card.
     */
    public IdentityCard build() {
        return new IdentityCard(number, country);
    }
}
