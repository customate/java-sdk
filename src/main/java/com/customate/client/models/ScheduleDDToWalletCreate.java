package com.customate.client.models;

import com.customate.client.enums.Currency;
import com.customate.client.enums.SchedulePeriod;
import com.customate.client.enums.SchedulePurpose;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * Models a direct debit to wallet schedule (used on creation).
 *
 * Date: 17-Mar-21
 * Time: 11:29 AM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScheduleDDToWalletCreate extends BaseModel {

    @JsonProperty("title")
    private String title;
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
    @JsonProperty("funding_source_id")
    private UUID fundingSourceId;
    @JsonProperty("payee_id")
    private UUID payeeId;

    /**
     * Default constructor.
     */
    public ScheduleDDToWalletCreate() { }

    /**
     * Constructor.
     *
     * @param title  Schedule title.
     * @param schedulePurpose  Purpose - pay or receive.
     * @param schedulePeriod  Period - one_time, daily, weekly, monthly, quarterly, yearly.
     * @param numberOfPayments  Number of payments.
     * @param regularPaymentStartDate  Start date of regular payments, in YYYY-MM-DD format.
     * @param regularPaymentAmount  Amount of regular payments, in pence/cents.
     * @param depositPaymentDate  Date of deposit, in YYYY-MM-DD format.
     * @param depositPaymentAmount  Deposit amount.
     * @param description  Description.
     * @param metadata  Metadata in JSON format.
     * @param fundingSourceId  The funding source used to make the payments.
     * @param payeeId  Payee ID.
     */
    public ScheduleDDToWalletCreate(String title, SchedulePurpose schedulePurpose, SchedulePeriod schedulePeriod,
                                    long numberOfPayments, String regularPaymentStartDate, long regularPaymentAmount,
                                    String depositPaymentDate, long depositPaymentAmount, String description, JsonNode metadata,
                                    UUID fundingSourceId, UUID payeeId) {
        this.title = title;
        this.schedulePurpose = schedulePurpose;
        this.schedulePeriod = schedulePeriod;
        this.numberOfPayments = numberOfPayments;
        this.regularPaymentStartDate = regularPaymentStartDate;
        this.regularPaymentAmount = regularPaymentAmount;
        this.depositPaymentDate = depositPaymentDate;
        this.depositPaymentAmount = depositPaymentAmount;
        this.description = description;
        this.metadata = metadata;
        this.fundingSourceId = fundingSourceId;
        this.payeeId = payeeId;
    }

}
