package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models a schedule (used for updates).
 *
 * Date: 08-Mar-21
 * Time: 12:00 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScheduleUpdate extends BaseModel {

    @JsonProperty("title")
    private String title;
    @JsonProperty("number_of_payments")
    private long numberOfPayments;
    @JsonProperty("regular_payment_amount")
    private long regularPaymentAmount;
    @JsonProperty("description")
    private String description;
    @JsonProperty("metadata")
    private JsonNode metadata;

    /**
     * Default constructor.
     */
    public ScheduleUpdate() { }

    /**
     * Constructor.
     *
     * @param title  Schedule title.
     * @param numberOfPayments  Number of payments.
     * @param regularPaymentAmount  Amount of regular payments, in pence/cents.
     * @param description  Description.
     * @param metadata  Metadata in JSON format.
     */
    public ScheduleUpdate(String title, long numberOfPayments, long regularPaymentAmount, String description, JsonNode metadata) {
        this.title = title;
        this.numberOfPayments = numberOfPayments;
        this.regularPaymentAmount = regularPaymentAmount;
        this.description = description;
        this.metadata = metadata;
    }

}
