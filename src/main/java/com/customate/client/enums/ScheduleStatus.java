package com.customate.client.enums;

/**
 * Enumeration of schedule statuses.
 * 
 * Date: 05-Mar-21
 * Time: 1:46 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public enum ScheduleStatus {

    open("open"),
    closed("closed"),
    stopped("stopped"),
    pending("pending"),
    rejected("rejected");

    private String scheduleStatus;

    /**
     * Constructor.
     *
     * @param scheduleStatus  The schedule status as a string.
     */
    ScheduleStatus(String scheduleStatus) {
        this.scheduleStatus = scheduleStatus;
    }

    /**
     * Returns the schedule status as a string.
     */
    @Override
    public String toString() {
        return scheduleStatus;
    }

    /**
     * Gets the schedule status from the input string.
     *
     * @param text  ScheduleStatus to find.
     * @return ScheduleStatus  The schedule status found.
     */
    public static ScheduleStatus fromString(String text) {
        for (ScheduleStatus scheduleStatus : ScheduleStatus.values()) {
            if (scheduleStatus.scheduleStatus.equalsIgnoreCase(text)) {
                return scheduleStatus;
            }
        }
        return null;
    }

}
