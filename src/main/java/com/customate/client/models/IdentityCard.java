package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models an identity card (for a verification request).
 *
 * Date: 25-Oct-23
 * Time: 3:17 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class IdentityCard extends BaseModel {

    @JsonProperty("number")
    private String number;
    /**
     * 2-digit ISO country code.
     */
    @JsonProperty("country")
    private String country;

    /**
     * Default constructor.
     */
    public IdentityCard() { }

    /**
     * Constructor.
     *
     * @param number  Licence number.
     * @param country  2-digit ISO country code.
     */
    public IdentityCard(String number, String country) {
        this.number = number;
        this.country = country;
    }

}
