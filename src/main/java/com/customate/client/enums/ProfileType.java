package com.customate.client.enums;

/**
 * Enumeration of profile types.
 * 
 * Date: 11-Feb-21
 * Time: 10:25 AM
 *
 * @author Sav Balac
 * @version 1.0
 */
public enum ProfileType {
    personal("personal"),
    business("business");

    private String profileType;

    /**
     * Constructor.
     *
     * @param profileType  The profile type as a string.
     */
    ProfileType(String profileType) {
        this.profileType = profileType;
    }

    /**
     * Returns the profile type as a string.
     */
    @Override
    public String toString() {
        return profileType;
    }

    /**
     * Gets the profile type from the input string.
     *
     * @param text  Profile type to find.
     * @return ProfileType  The profile type found.
     */
    public static ProfileType fromString(String text) {
        for (ProfileType profileType : ProfileType.values()) {
            if (profileType.profileType.equalsIgnoreCase(text)) {
                return profileType;
            }
        }
        return null;
    }
}
