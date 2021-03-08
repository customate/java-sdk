package com.customate.client.builders;

import com.customate.client.models.Schedule;
import com.customate.client.models.ScheduleUpdate;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Builds a schedule for update.
 *
 * Date: 08-Mar-21
 * Time: 12:21 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class ScheduleUpdateBuilder {

    private String title;
    private long numberOfPayments;
    private long regularPaymentAmount;
    private String description;
    private JsonNode metadata;

    /**
     * Sets the title.
     *
     * @param title  Title.
     * @return ScheduleUpdateBuilder  The updated schedule builder.
     */
    public ScheduleUpdateBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Sets the number of payments.
     *
     * @param numberOfPayments  Number of payments.
     * @return ScheduleUpdateBuilder  The updated schedule builder.
     */
    public ScheduleUpdateBuilder setNumberOfPayments(long numberOfPayments) {
        this.numberOfPayments = numberOfPayments;
        return this;
    }

    /**
     * Sets the regular payment amount.
     *
     * @param regularPaymentAmount  Regular payment amount.
     * @return ScheduleUpdateBuilder  The updated schedule builder.
     */
    public ScheduleUpdateBuilder setRegularPaymentAmount(long regularPaymentAmount) {
        this.regularPaymentAmount = regularPaymentAmount;
        return this;
    }

    /**
     * Sets the description.
     *
     * @param description  Description.
     * @return ScheduleUpdateBuilder  The updated schedule builder.
     */
    public ScheduleUpdateBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Sets the metadata.
     *
     * @param metadata  Metadata.
     * @return ScheduleUpdateBuilder  The updated schedule builder.
     */
    public ScheduleUpdateBuilder setMetadata(JsonNode metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Copies the data from an existing schedule.
     *
     * @param schedule  The schedule to copy.
     * @return ScheduleUpdateBuilder  The updated schedule builder.
     */
    public ScheduleUpdateBuilder copySchedule(Schedule schedule) {
        this.title = schedule.getTitle();
        this.numberOfPayments = schedule.getNumberOfPayments();
        this.regularPaymentAmount = schedule.getRegularPaymentAmount();
        this.description = schedule.getDescription();
        this.metadata = schedule.getMetadata();
        return this;
    }

    /**
     * Builds a schedule for update.
     *
     * @return ScheduleUpdateBuilder  The schedule for update.
     */
    public ScheduleUpdate build() {
        return new ScheduleUpdate(title, numberOfPayments, regularPaymentAmount, description, metadata);
    }

}
