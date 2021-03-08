package com.customate.client.models;

import com.customate.client.enums.Currency;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * Models a payment (for creation). The funding source is the payer.
 *
 * Date: 03-Mar-21
 * Time: 1:22 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentFundingSourceToPayeeCreate extends BaseModel {

    @JsonProperty("amount")
    private long amount;
    @JsonProperty("description")
    private String description;
    /**
     * 3-digit ISO currency code
     */
    @JsonProperty("currency")
    private Currency currency;
    /**
     * Execution date in in YYYY-MM-DD format.
     */
    @JsonProperty("execution_date")
    private String executionDate;
    @JsonProperty("metadata")
    private JsonNode metadata;
    @JsonProperty("funding_source_id")
    private UUID fundingSourceId;
    @JsonProperty("payee_id")
    private UUID payeeId;

    /**
     * Default constructor.
     */
    public PaymentFundingSourceToPayeeCreate() { }

    /**
     * Constructor.
     *
     * @param amount  Amount in pence/cents.
     * @param description  Description of payment.
     * @param currency  Currency.
     * @param executionDate  Execution date in in YYYY-MM-DD format.
     * @param metadata  Metadata.
     * @param payeeId  ID of the payee.
     * @param fundingSourceId  ID of the funding source (payer).
     */
    public PaymentFundingSourceToPayeeCreate(long amount, String description, Currency currency,
                                             String executionDate, JsonNode metadata, UUID fundingSourceId, UUID payeeId) {
        this.amount = amount;
        this.description = description;
        this.currency = currency;
        this.executionDate = executionDate;
        this.metadata = metadata;
        this.payeeId = payeeId;
        this.fundingSourceId = fundingSourceId;
    }

}
