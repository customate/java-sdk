package com.customate.client.models;

import com.customate.client.enums.Currency;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * Models a wallet for the all wallets list.
 * 
 * Date: 17-Mar-23
 * Time: 6:10 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class AllWallet extends BaseModel {

    @JsonProperty("id")
    private UUID id;
    @JsonProperty("iban")
    private String iban;
    @JsonProperty("currency")
    private Currency currency;
    @JsonProperty("balance")
    private long balance;
    @JsonProperty("actual_balance")
    private long actualBalance;
    @JsonProperty("closing_balance")
    private long closingBalance;

    /**
     * Default constructor.
     */
    public AllWallet() { }

}
