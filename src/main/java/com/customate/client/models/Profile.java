package com.customate.client.models;

import com.customate.client.enums.Gender;
import com.customate.client.enums.ProfileType;
import com.customate.client.enums.Title;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * Models a user profile.
 * 
 * Date: 05-Feb-21
 * Time: 3:01 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Profile extends BaseModel {

    @JsonProperty("id")
    private UUID id;
    @JsonProperty("type")
    private ProfileType type;
    @JsonProperty("title")
    private Title title;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("middle_name")
    private String middleName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("email")
    private String email;
    @JsonProperty("verification")
    private VerificationResponse verificationResponse;
    @JsonProperty("phone_number")
    private String phoneNumber;
    @JsonProperty("birth_date")
    private String birthDate;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("gender")
    private Gender gender;
    @JsonProperty("is_active")
    private boolean isActive;
    @JsonProperty("creation_datetime")
    private String creationDatetime;
    @JsonProperty("metadata")
    private JsonNode metadata;

    /**
     * Default constructor.
     */
    public Profile() { }

    /**
     * Constructor.
     *
     * @param type  personal or business.
     * @param title  mr, mrs, miss, ms, other.
     * @param firstName  forename.
     * @param middleName  middle name.
     * @param lastName  surname.
     * @param email  email address - must be unique in the system.
     * @param phoneNumber  phone number in international format, e.g. +447917654352.
     * @param birthDate  date of birth in YYYY-MM-DD format.
     * @param address  Address.
     * @param gender  male, female, other.
     * @param metadata  Metadata as a JSON node.
     */
    public Profile(ProfileType type, Title title, String firstName, String middleName, String lastName, String email,
                   String phoneNumber, String birthDate, Address address, Gender gender, JsonNode metadata) {
        this.type = type;
        this.title = title;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.address = address;
        this.gender = gender;
        this.metadata = metadata;
    }

}
