package com.customate.client.models;

import com.customate.client.enums.Currency;
import com.customate.client.enums.PaymentStatus;
import com.customate.client.enums.PaymentScenario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * Models a payment.
 *
 * Date: 15-Feb-21
 * Time: 3:21 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Payment extends BaseModel {

    @JsonProperty("id")
    private UUID id;
    @JsonProperty("status")
    private PaymentStatus paymentStatus;
    @JsonProperty("schedule_id")
    private UUID scheduleId;
    @JsonProperty("currency")
    private Currency currency;
    @JsonProperty("scenario")
    private PaymentScenario scenario;
    @JsonProperty("metadata")
    private JsonNode paymentMetadata;
    @JsonProperty("wallet_id")
    private UUID walletId;
    @JsonProperty("execution_date")
    private String executionDate;
    @JsonProperty("funding_source")
    private JsonNode fundingSource;
    @JsonProperty("payee")
    private JsonNode payee;
    @JsonProperty("amount")
    private long amount;
    @JsonProperty("description")
    private String description;
    @JsonProperty("creation_datetime")
    private String creationDatetime;

    /**
     * Default constructor.
     */
    public Payment() { }

}
