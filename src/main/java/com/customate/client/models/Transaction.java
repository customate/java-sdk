package com.customate.client.models;

import com.customate.client.enums.TransactionName;
import com.customate.client.enums.TransactionStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * Models a transaction.
 * 
 * Date: 15-Feb-21
 * Time: 2:43 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction extends BaseModel {

    @JsonProperty("id")
    private UUID id;
    @JsonProperty("amount")
    private long amount;
    @JsonProperty("closing_balance")
    private long closingBalance;
    @JsonProperty("name")
    private TransactionName name;
    @JsonProperty("status")
    private TransactionStatus status;
    @JsonProperty("payment")
    private JsonNode payment;
    @JsonProperty("completion_datetime")
    private String completionDatetime;
    @JsonProperty("fee")
    private long fee;
    @JsonProperty("funding_source")
    private JsonNode fundingSource;
    @JsonProperty("payee")
    private JsonNode payee;
    @JsonProperty("creation_datetime")
    private String creationDatetime;

    /**
     * Default constructor.
     */
    public Transaction() { }
}
