package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models wallet data (bank, account).
 *
 * Date: 11-Feb-21
 * Time: 3:36 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class WalletData extends BaseModel {

    @JsonProperty("bank")
    private Bank bank;
    @JsonProperty("account")
    private Account account;

    /**
     * Default constructor.
     */
    public WalletData() { }
}
