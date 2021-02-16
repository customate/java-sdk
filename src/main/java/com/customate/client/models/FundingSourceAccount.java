package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models an account (in funding source data).
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
public class FundingSourceAccount extends BaseModel {

    @JsonProperty("sort_code")
    private String sortCode;
    @JsonProperty("account_number")
    private String accountNumber;

    /**
     * Default constructor.
     */
    public FundingSourceAccount() { }

    /**
     * Constructor.
     *
     * @param sortCode  Sort code.
     * @param accountNumber  Account number.
     */
    public FundingSourceAccount(String sortCode, String accountNumber) {
        this.sortCode = sortCode;
        this.accountNumber = accountNumber;
    }
}
