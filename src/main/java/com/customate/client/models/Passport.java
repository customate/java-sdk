package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models a passport (for a profile verification request).
 *
 * Date: 05-Feb-21
 * Time: 3:38 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Passport extends BaseModel {

    /**
     * 2-digit ISO country code.
     */
    @JsonProperty("origin_country")
    private String originCountry;
    @JsonProperty("number")
    private String number;
    /**
     * Date in YYYY-MM-DD format.
     */
    @JsonProperty("expiry_date")
    private String expiryDate;

    /**
     * Default constructor.
     */
    public Passport() { }

    /**
     * Constructor.
     *
     * @param originCountry  Country of origin, 2-digit ISO country code.
     * @param number  Passport number.
     * @param expiryDate  Expiry date in YYYY-MM-DD format.
     */
    public Passport(String originCountry, String number, String expiryDate) {
        this.originCountry = originCountry;
        this.number = number;
        this.expiryDate = expiryDate;
    }

}
