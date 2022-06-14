package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models a funding source payer (for validation).
 *
 * Date: 14-Jun-22
 * Time: 1:57 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class FundingSourceValidatePayer extends BaseModel {

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("birth_date")
    private String birthDate;

    @JsonProperty("email")
    private String email;

    @JsonProperty("address")
    private FundingSourceAddress fundingSourceAddress;

    /**
     * Default constructor.
     */
    public FundingSourceValidatePayer() { }

    /**
     * Constructor.
     *
     * @param firstName  Forename.
     * @param lastName  Surname.
     * @param birthDate  Date of birth.
     * @param email  Email address.
     * @param fundingSourceAddress  Funding source address.
     */
    public FundingSourceValidatePayer(String firstName, String lastName, String birthDate,
                                      String email, FundingSourceAddress fundingSourceAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.fundingSourceAddress = fundingSourceAddress;
    }
}
