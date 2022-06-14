package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models an address used in a payee.
 * 
 * Date: 13-Jun-22
 * Time: 4:11 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PayeeAddress extends BaseModel {

    @JsonProperty("city")
    private String city;
    /**
     * 2-digit ISO country code.
     */
    @JsonProperty("country")
    private String country;
    @JsonProperty("locality")
    private String locality;
    @JsonProperty("postcode")
    private String postcode;
    @JsonProperty("address_line_1")
    private String addressLine1;
    @JsonProperty("address_line_2")
    private String addressLine2;
    @JsonProperty("address_line_3")
    private String addressLine3;

    /**
     * Default constructor.
     */
    public PayeeAddress() { }

    /**
     * Constructor.
     *
     * @param addressLine1  Line 1.
     * @param addressLine2  Line 2.
     * @param addressLine3  Line 3.
     * @param city  City.
     * @param locality  County.
     * @param postcode  Post code.
     * @param country  2-digit ISO country code.
     */
    public PayeeAddress(String addressLine1, String addressLine2, String addressLine3, String city, String locality, String postcode, String country) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.city = city;
        this.locality = locality;
        this.postcode = postcode;
        this.country = country;
    }

}
