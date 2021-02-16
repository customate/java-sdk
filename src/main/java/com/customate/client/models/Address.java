package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models an address.
 * 
 * Date: 05-Feb-21
 * Time: 3:41 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address extends BaseModel {

    @JsonProperty("line_1")
    private String line1;
    @JsonProperty("line_2")
    private String line2;
    @JsonProperty("line_3")
    private String line3;
    @JsonProperty("city")
    private String city;
    @JsonProperty("locality")
    private String locality;
    @JsonProperty("postcode")
    private String postcode;
    /**
     * 2-digit ISO country code.
     */
    @JsonProperty("country")
    private String country;

    /**
     * Default constructor.
     */
    public Address() { }

    /**
     * Constructor.
     *
     * @param line1  Line 1.
     * @param line2  Line 2.
     * @param line3  Line 3.
     * @param city  City.
     * @param locality  County.
     * @param postcode  Post code.
     * @param country  2-digit ISO country code.
     */
    public Address(String line1, String line2, String line3, String city, String locality, String postcode, String country) {
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.city = city;
        this.locality = locality;
        this.postcode = postcode;
        this.country = country;
    }

}
