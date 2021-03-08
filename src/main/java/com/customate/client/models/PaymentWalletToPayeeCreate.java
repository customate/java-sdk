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
 * Models a wallet to payee payment (for creation).
 *
 * Date: 02-Mar-21
 * Time: 11:02 AM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentWalletToPayeeCreate extends BaseModel {

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
    @JsonProperty("payee_id")
    private UUID payeeId;

    /**
     * Default constructor.
     */
    public PaymentWalletToPayeeCreate() { }

    /**
     * Constructor.
     *
     * @param amount  Amount in pence/cents.
     * @param description  Description of payment.
     * @param currency  Currency.
     * @param executionDate  Execution date in in YYYY-MM-DD format.
     * @param metadata  Metadata.
     * @param payeeId  ID of the payee.
     */
    public PaymentWalletToPayeeCreate(long amount, String description, Currency currency,
                                      String executionDate, JsonNode metadata, UUID payeeId) {
        this.amount = amount;
        this.description = description;
        this.currency = currency;
        this.executionDate = executionDate;
        this.metadata = metadata;
        this.payeeId = payeeId;
    }

}
