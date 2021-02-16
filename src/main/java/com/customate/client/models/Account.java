package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models an account (in wallet data).
 * 
 * Date: 11-Feb-21
 * Time: 3:21 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account extends BaseModel {

    @JsonProperty("bic")
    private String bic;
    @JsonProperty("iban")
    private String iban;
    @JsonProperty("account_number")
    private String accountNumber;
    @JsonProperty("sort_code")
    private String sortCode;

    /**
     * Default constructor.
     */
    public Account() { }

}
