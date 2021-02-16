package com.customate.client.models;

import com.customate.client.enums.Currency;
import com.customate.client.enums.FundingSourceType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.UUID;

/**
 * Models a funding source.
 *
 * Date: 11-Feb-21
 * Time: 4:18 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class FundingSource extends BaseModel {

    @JsonProperty("title")
    private String title;
    @JsonProperty("type")
    private FundingSourceType fundingSourceType;
    @JsonProperty("currency")
    private Currency currency;
    @JsonProperty("data")
    private FundingSourceData fundingSourceData;
    @JsonProperty("id")
    private UUID id;
    @JsonProperty("metadata")
    private JsonNode metadata;
    @JsonProperty("creation_datetime")
    private String creationDateTime;
    @JsonProperty("validation")
    private FundingSourceValidation fundingSourceValidation;

    /**
     * Default constructor.
     */
    public FundingSource() { }

    /**
     * Constructor.
     *
     * @param title  Name of funding source.
     * @param fundingSourceType  credit_card, direct_debit, open_banking, virtual_wallet, wallet.
     * @param currency  GBP, EUR.
     * @param fundingSourceData  id, bank, account, balance.
     * @param metadata  metadata.
     */
    public FundingSource(String title, FundingSourceType fundingSourceType,
                         Currency currency, FundingSourceData fundingSourceData, JsonNode metadata) {
        this.title = title;
        this.fundingSourceType = fundingSourceType;
        this.currency = currency;
        this.fundingSourceData = fundingSourceData;
        this.metadata = metadata;
    }
}
