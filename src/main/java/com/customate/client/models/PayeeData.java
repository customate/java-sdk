package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models payee data.
 *
 * Date: 19-Feb-21
 * Time: 4:53 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PayeeData extends BaseModel {

    @JsonProperty("bank")
    private Bank bank;
    @JsonProperty("account")
    private PayeeAccount payeeAccount;
    @JsonProperty("walletId")
    private String walletId;
    @JsonProperty("recipient")
    private Recipient recipient;

    /**
     * Default constructor.
     */
    public PayeeData() { }

}
