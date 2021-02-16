package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * Models funding source data.
 *
 * Date: 11-Feb-21
 * Time: 4:30 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class FundingSourceData extends BaseModel {

    @JsonProperty("walletId")
    private String walletId;
    @JsonProperty("iban")
    private String iban;
    @JsonProperty("bank")
    private FundingSourceBank fundingSourceBank;
    @JsonProperty("account")
    private FundingSourceAccount fundingSourceAccount;
    @JsonProperty("balance")
    private long balance;

    /**
     * Default constructor.
     */
    public FundingSourceData() { }

    /**
     * Constructor.
     *
     * @param walletId  Wallet ID.
     * @param iban  IBAN.
     * @param fundingSourceBank  Bank details.
     * @param fundingSourceAccount  Account details.
     * @param balance  Balance.
     */
    public FundingSourceData(String walletId, String iban, FundingSourceBank fundingSourceBank, FundingSourceAccount fundingSourceAccount, long balance) {
        this.walletId = walletId;
        this.iban = iban;
        this.fundingSourceBank = fundingSourceBank;
        this.fundingSourceAccount = fundingSourceAccount;
        this.balance = balance;
    }
}
