package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models a bank (in wallet data).
 *
 * Date: 11-Feb-21
 * Time: 3:14 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bank extends BaseModel {

    @JsonProperty("name")
    private String name;
    @JsonProperty("address")
    private Address address;

    /**
     * Default constructor.
     */
    public Bank() { }

}
