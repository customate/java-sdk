package com.customate.client.models;

import com.customate.client.enums.Currency;
import com.customate.client.enums.SchedulePeriod;
import com.customate.client.enums.SchedulePurpose;
import com.customate.client.enums.ScheduleStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * Models a schedule.
 *
 * Date: 05-Mar-21
 * Time: 1:37 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Schedule extends BaseModel {

    @JsonProperty("id")
    private UUID id;
    @JsonProperty("creation_datetime")
    private String creationDatetime;
    @JsonProperty("title")
    private String title;
    @JsonProperty("status")
    private ScheduleStatus scheduleStatus;
    @JsonProperty("is_overdue")
    private boolean isOverdue;
    @JsonProperty("currency")
    private Currency currency;
    @JsonProperty("purpose")
    private SchedulePurpose schedulePurpose;
    @JsonProperty("period")
    private SchedulePeriod schedulePeriod;
    @JsonProperty("number_of_payments")
    private long numberOfPayments;
    /**
     * Date in YYYY-MM-DD format.
     */
    @JsonProperty("regular_payment_start_date")
    private String regularPaymentStartDate;
    @JsonProperty("regular_payment_amount")
    private long regularPaymentAmount;
    /**
     * Date in YYYY-MM-DD format.
     */
    @JsonProperty("deposit_payment_date")
    private String depositPaymentDate;
    @JsonProperty("deposit_payment_amount")
    private long depositPaymentAmount;
    @JsonProperty("description")
    private String description;
    @JsonProperty("metadata")
    private JsonNode metadata;
    @JsonProperty("funding_source")
    private JsonNode fundingSource;
    @JsonProperty("backup_funding_source")
    private JsonNode backupFundingSource;
    @JsonProperty("payee")
    private JsonNode payee;

    /**
     * Default constructor.
     */
    public Schedule() { }

}
