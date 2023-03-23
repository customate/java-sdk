package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Models a page of wallets for the all wallets list.
 * 
 * Date: 17-Mar-23
 * Time: 6:12 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class AllWalletPage extends BaseModel {

    @JsonProperty("items")
    private List<AllWallet> items;
    @JsonProperty("meta")
    private Pagination meta;
    @JsonProperty("totals")
    private AllWalletTotals totals;

    /**
     * Default constructor.
     */
    public AllWalletPage() { }

}
