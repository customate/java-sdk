package com.customate.client.models;

import com.customate.client.enums.Currency;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * Models the totals for the all wallets list.
 * 
 * Date: 17-Mar-23
 * Time: 6:14 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class AllWalletTotals extends BaseModel {

    @JsonProperty("total_balance")
    private long totalBalance;
    @JsonProperty("total_actual_balance")
    private long totalActualBalance;
    @JsonProperty("total_closing_balance")
    private long totalClosingBalance;

    /**
     * Default constructor.
     */
    public AllWalletTotals() { }

}
