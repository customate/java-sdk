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
 * Models an open banking mandate payment (for creation).
 *
 * Date: 19-Jan-23
 * Time: 3:46 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentOpenBankingMandateCreate extends BaseModel {

    @JsonProperty("amount")
    private long amount;
    @JsonProperty("description")
    private String description;
    @JsonProperty("currency")
    private Currency currency;
    @JsonProperty("metadata")
    private JsonNode metadata;
    @JsonProperty("beneficiary_name")
    private String beneficiaryName;
    @JsonProperty("mandate_id")
    private UUID mandateId;

    /**
     * Default constructor.
     */
    public PaymentOpenBankingMandateCreate() { }

    /**
     * Constructor.
     *
     * @param amount  Amount in cents.
     * @param description  Description of payment.
     * @param currency  Currency.
     * @param metadata  Metadata.
     * @param beneficiaryName  Beneficiary name.
     * @param mandateId  Mandate ID.
     */
    public PaymentOpenBankingMandateCreate(long amount, String description, Currency currency,
                                           JsonNode metadata, String beneficiaryName, UUID mandateId) {
        this.amount = amount;
        this.description = description;
        this.currency = currency;
        this.metadata = metadata;
        this.beneficiaryName = beneficiaryName;
        this.mandateId = mandateId;
    }

}
