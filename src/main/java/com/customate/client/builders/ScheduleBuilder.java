package com.customate.client.builders;

import com.customate.client.enums.Currency;
import com.customate.client.enums.SchedulePeriod;
import com.customate.client.enums.SchedulePurpose;
import com.customate.client.models.ScheduleCreate;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.UUID;

/**
 * Builds a schedule.
 *
 * Date: 05-Mar-21
 * Time: 3:37 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class ScheduleBuilder {

    private String title;
    private Currency currency;
    private SchedulePurpose schedulePurpose;
    private SchedulePeriod schedulePeriod;
    private long numberOfPayments;
    /**
     * Date in YYYY-MM-DD format.
     */
    private String regularPaymentStartDate;
    private long regularPaymentAmount;
    /**
     * Date in YYYY-MM-DD format.
     */
    private String depositPaymentDate;
    private long depositPaymentAmount;
    private String description;
    private JsonNode metadata;
    private UUID fundingSourceId;
    private UUID payeeId;

    /**
     * Sets the title.
     *
     * @param title  Title.
     * @return ScheduleBuilder  The updated schedule builder.
     */
    public ScheduleBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Sets the currency.
     *
     * @param currency  Currency.
     * @return ScheduleBuilder  The updated schedule builder.
     */
    public ScheduleBuilder setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Sets the title.
     *
     * @param schedulePurpose  Schedule purpose.
     * @return ScheduleBuilder  The updated schedule builder.
     */
    public ScheduleBuilder setSchedulePurpose(SchedulePurpose schedulePurpose) {
        this.schedulePurpose = schedulePurpose;
        return this;
    }

    /**
     * Sets the schedule period.
     *
     * @param schedulePeriod  Schedule period.
     * @return ScheduleBuilder  The updated schedule builder.
     */
    public ScheduleBuilder setSchedulePeriod(SchedulePeriod schedulePeriod) {
        this.schedulePeriod = schedulePeriod;
        return this;
    }

    /**
     * Sets the number of payments.
     *
     * @param numberOfPayments  Number of payments.
     * @return ScheduleBuilder  The updated schedule builder.
     */
    public ScheduleBuilder setNumberOfPayments(long numberOfPayments) {
        this.numberOfPayments = numberOfPayments;
        return this;
    }

    /**
     * Sets the regular payment start date.
     *
     * @param regularPaymentStartDate  Regular payment start date.
     * @return ScheduleBuilder  The updated schedule builder.
     */
    public ScheduleBuilder setRegularPaymentStartDate(String regularPaymentStartDate) {
        this.regularPaymentStartDate = regularPaymentStartDate;
        return this;
    }

    /**
     * Sets the regular payment amount.
     *
     * @param regularPaymentAmount  Regular payment amount.
     * @return ScheduleBuilder  The updated schedule builder.
     */
    public ScheduleBuilder setRegularPaymentAmount(long regularPaymentAmount) {
        this.regularPaymentAmount = regularPaymentAmount;
        return this;
    }

    /**
     * Sets the deposit payment date.
     *
     * @param depositPaymentDate  Deposit payment date.
     * @return ScheduleBuilder  The updated schedule builder.
     */
    public ScheduleBuilder setDepositPaymentDate(String depositPaymentDate) {
        this.depositPaymentDate = depositPaymentDate;
        return this;
    }

    /**
     * Sets the deposit payment amount.
     *
     * @param depositPaymentAmount  Deposit payment amount.
     * @return ScheduleBuilder  The updated schedule builder.
     */
    public ScheduleBuilder setDepositPaymentAmount(long depositPaymentAmount) {
        this.depositPaymentAmount = depositPaymentAmount;
        return this;
    }

    /**
     * Sets the description.
     *
     * @param description  Description.
     * @return ScheduleBuilder  The updated schedule builder.
     */
    public ScheduleBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Sets the metadata.
     *
     * @param metadata  Metadata.
     * @return ScheduleBuilder  The updated schedule builder.
     */
    public ScheduleBuilder setMetadata(JsonNode metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Sets the funding source ID.
     *
     * @param fundingSourceId  Funding source ID.
     * @return ScheduleBuilder  The updated schedule builder.
     */
    public ScheduleBuilder setFundingSourceId(UUID fundingSourceId) {
        this.fundingSourceId = fundingSourceId;
        return this;
    }

    /**
     * Sets the payee ID.
     *
     * @param payeeId  Payee ID.
     * @return ScheduleBuilder  The updated schedule builder.
     */
    public ScheduleBuilder setPayeeId(UUID payeeId) {
        this.payeeId = payeeId;
        return this;
    }

    /**
     * Builds a schedule.
     *
     * @return ScheduleCreate  The schedule.
     */
    public ScheduleCreate build() {
        return new ScheduleCreate(title, currency, schedulePurpose, schedulePeriod, numberOfPayments,
                regularPaymentStartDate, regularPaymentAmount, depositPaymentDate, depositPaymentAmount, description,
                metadata, fundingSourceId, payeeId);
    }

}
