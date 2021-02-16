package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models a driving licence (for a profile verification request).
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
public class DriverLicence extends BaseModel {

    @JsonProperty("number")
    private String number;
    @JsonProperty("postcode")
    private String postcode;
    /**
     * Date in YYYY-MM-DD format.
     */
    @JsonProperty("issue_date")
    private String issueDate;

    /**
     * Default constructor.
     */
    public DriverLicence() { }

    /**
     * Constructor.
     *
     * @param number  Licence number.
     * @param postcode  Driver's postcode.
     * @param issueDate  Issue date in YYYY-MM-DD format.
     */
    public DriverLicence(String number, String postcode, String issueDate) {
        this.number = number;
        this.postcode = postcode;
        this.issueDate = issueDate;
    }

}
