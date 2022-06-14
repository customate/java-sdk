package com.customate.client.builders;

import com.customate.client.models.Address;
import com.customate.client.models.FundingSourceAddress;

/**
 * Builds an address.
 *
 * Date: 13-Jun-22
 * Time: 2:06 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class FundingSourceAddressBuilder {

    private String city;
    private String country;
    private String locality;
    private String postcode;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;

    /**
     * Sets address line 1.
     *
     * @param addressLine1  Address line 1.
     * @return FundingSourceAddressBuilder  Updated address builder.
     */
    public FundingSourceAddressBuilder setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    /**
     * Sets address line 2.
     *
     * @param addressLine2  Address line 2.
     * @return FundingSourceAddressBuilder  Updated address builder.
     */
    public FundingSourceAddressBuilder setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    /**
     * Sets address line 3.
     *
     * @param addressLine3  Address line 3.
     * @return FundingSourceAddressBuilder  Updated address builder.
     */
    public FundingSourceAddressBuilder setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
        return this;
    }

    /**
     * Sets the city.
     *
     * @param city  City.
     * @return AddressBuilder  Updated address builder.
     */
    public FundingSourceAddressBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    /**
     * Sets the locality (county).
     *
     * @param locality  Locality.
     * @return AddressBuilder  Updated address builder.
     */
    public FundingSourceAddressBuilder setLocality(String locality) {
        this.locality = locality;
        return this;
    }

    /**
     * Sets the post code.
     *
     * @param postcode  Post code.
     * @return AddressBuilder  Updated address builder.
     */
    public FundingSourceAddressBuilder setPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    /**
     * Sets the country (2-digit ISO country code).
     *
     * @param country  Country.
     * @return AddressBuilder  Updated address builder.
     */
    public FundingSourceAddressBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    /**
     * Builds a funding source address.
     *
     * @return FundingSourceAddress  The funding source address.
     */
    public FundingSourceAddress build() {
        return new FundingSourceAddress(addressLine1, addressLine2, addressLine3, city, locality, postcode, country);
    }
}
