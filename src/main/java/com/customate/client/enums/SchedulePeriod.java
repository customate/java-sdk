package com.customate.client.enums;

/**
 * Enumeration of schedule periods.
 * 
 * Date: 05-Mar-21
 * Time: 1:54 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public enum SchedulePeriod {

    one_time("one_time"),
    daily("daily"),
    weekly("weekly"),
    monthly("monthly"),
    quarterly("quarterly"),
    yearly("yearly");

    private String schedulePeriod;

    /**
     * Constructor.
     *
     * @param schedulePeriod  The schedule period as a string.
     */
    SchedulePeriod(String schedulePeriod) {
        this.schedulePeriod = schedulePeriod;
    }

    /**
     * Returns the schedule period as a string.
     */
    @Override
    public String toString() {
        return schedulePeriod;
    }

    /**
     * Gets the schedule period from the input string.
     *
     * @param text  SchedulePeriod to find.
     * @return SchedulePeriod  The schedule period found.
     */
    public static SchedulePeriod fromString(String text) {
        for (SchedulePeriod schedulePeriod : SchedulePeriod.values()) {
            if (schedulePeriod.schedulePeriod.equalsIgnoreCase(text)) {
                return schedulePeriod;
            }
        }
        return null;
    }

}
