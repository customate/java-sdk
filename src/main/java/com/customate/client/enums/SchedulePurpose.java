package com.customate.client.enums;

/**
 * Enumeration of schedule purposes.
 * 
 * Date: 05-Mar-21
 * Time: 3:30 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public enum SchedulePurpose {

    pay("pay"),
    receive("receive");

    private String schedulePurpose;

    /**
     * Constructor.
     *
     * @param schedulePurpose  The schedule purpose as a string.
     */
    SchedulePurpose(String schedulePurpose) {
        this.schedulePurpose = schedulePurpose;
    }

    /**
     * Returns the schedule purpose as a string.
     */
    @Override
    public String toString() {
        return schedulePurpose;
    }

    /**
     * Gets the schedule purpose from the input string.
     *
     * @param text  SchedulePurpose to find.
     * @return SchedulePurpose  The schedule purpose found.
     */
    public static SchedulePurpose fromString(String text) {
        for (SchedulePurpose schedulePurpose : SchedulePurpose.values()) {
            if (schedulePurpose.schedulePurpose.equalsIgnoreCase(text)) {
                return schedulePurpose;
            }
        }
        return null;
    }

}
