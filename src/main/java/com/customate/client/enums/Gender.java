package com.customate.client.enums;

/**
 * Enumeration of genders.
 * 
 * Date: 11-Feb-21
 * Time: 10:25 AM
 *
 * @author Sav Balac
 * @version 1.0
 */
public enum Gender {
    male("male"),
    female("female"),
    other("other");

    private String gender;

    /**
     * Constructor.
     *
     * @param gender  The gender as a string.
     */
    Gender(String gender) {
        this.gender = gender;
    }

    /**
     * Returns the gender as a string.
     */
    @Override
    public String toString() {
        return gender;
    }

    /**
     * Gets the gender from the input string.
     *
     * @param text  Gender to find.
     * @return Gender  The gender found.
     */
    public static Gender fromString(String text) {
        for (Gender gender : Gender.values()) {
            if (gender.gender.equalsIgnoreCase(text)) {
                return gender;
            }
        }
        return null;
    }
}
