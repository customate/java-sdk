package com.customate.client.builders;

import com.customate.client.models.Address;

/**
 * Builds an address.
 *
 * Date: 09-Feb-21
 * Time: 4:27 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class AddressBuilder {

    private String line1;
    private String line2;
    private String line3;
    private String city;
    private String locality;
    private String postcode;
    private String country;

    /**
     * Sets line1.
     *
     * @param line1  Line 1.
     * @return AddressBuilder  Updated address builder.
     */
    public AddressBuilder setLine1(String line1) {
        this.line1 = line1;
        return this;
    }

    /**
     * Sets line2.
     *
     * @param line2  Line 2.
     * @return AddressBuilder  Updated address builder.
     */
    public AddressBuilder setLine2(String line2) {
        this.line2 = line2;
        return this;
    }

    /**
     * Sets line3.
     *
     * @param line3  Line 3.
     * @return AddressBuilder  Updated address builder.
     */
    public AddressBuilder setLine3(String line3) {
        this.line3 = line3;
        return this;
    }

    /**
     * Sets the city.
     *
     * @param city  City.
     * @return AddressBuilder  Updated address builder.
     */
    public AddressBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    /**
     * Sets the locality (county).
     *
     * @param locality  Locality.
     * @return AddressBuilder  Updated address builder.
     */
    public AddressBuilder setLocality(String locality) {
        this.locality = locality;
        return this;
    }

    /**
     * Sets the post code.
     *
     * @param postcode  Post code.
     * @return AddressBuilder  Updated address builder.
     */
    public AddressBuilder setPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    /**
     * Sets the country (2-digit ISO country code).
     *
     * @param country  Country.
     * @return AddressBuilder  Updated address builder.
     */
    public AddressBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    /**
     * Builds an address.
     *
     * @return Address  The address.
     */
    public Address build() {
        return new Address(line1, line2, line3, city, locality, postcode, country);
    }
}
