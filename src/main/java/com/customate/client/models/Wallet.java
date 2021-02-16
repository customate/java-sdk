package com.customate.client.models;

import com.customate.client.enums.Currency;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * Models a wallet.
 * 
 * Date: 11-Feb-21
 * Time: 3:00 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Wallet extends BaseModel {

    @JsonProperty("balance")
    private long balance;
    @JsonProperty("currency")
    private Currency currency;
    @JsonProperty("iban")
    private String iban;
    @JsonProperty("data")
    private WalletData walletData;
    @JsonProperty("id")
    private UUID id;

    /**
     * Default constructor.
     */
    public Wallet() { }

}
