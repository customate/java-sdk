package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models an account (in payee data).
 * 
 * Date: 19-Feb-21
 * Time: 5:34 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PayeeAccount extends BaseModel {

    @JsonProperty("iban")
    private String iban;
    @JsonProperty("sort_code")
    private String sortCode;
    @JsonProperty("account_number")
    private String accountNumber;

    /**
     * Default constructor.
     */
    public PayeeAccount() { }

    /**
     * Constructor.
     *
     * @param iban  IBAN (International Bank Account Number).
     * @param sortCode  Sort code.
     * @param accountNumber  Account number.
     */
    public PayeeAccount(String iban, String sortCode, String accountNumber) {
        this.iban = iban;
        this.sortCode = sortCode;
        this.accountNumber = accountNumber;
    }

}
