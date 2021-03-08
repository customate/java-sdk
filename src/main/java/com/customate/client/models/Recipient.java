package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models a recipient.
 * 
 * Date: 19-Feb-21
 * Time: 4:57 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Recipient extends BaseModel {

    @JsonProperty("email")
    private String email;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("full_name")
    private String fullName;

    /**
     * Default constructor.
     */
    public Recipient() { }

    /**
     * Constructor.
     *
     * @param email  Email address.
     * @param address  Address.
     * @param fullName  Full name.
     */
    public Recipient(String email, Address address, String fullName) {
        this.email = email;
        this.address = address;
        this.fullName = fullName;
    }

}
