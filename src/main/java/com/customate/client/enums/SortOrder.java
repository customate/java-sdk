package com.customate.client.enums;

/**
 * Enumeration of sort order values used in list methods.
 * 
 * Date: 17-Mar-23
 * Time: 3:06 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public enum SortOrder {
    asc(""), // Default
    desc("-"); // Specified by the frontend API

    private String sortOrder;

    /**
     * Constructor.
     *
     * @param sortOrder  The sortOrder as a string.
     */
    SortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * Returns the sort order as a string.
     */
    @Override
    public String toString() {
        return sortOrder;
    }

    /**
     * Gets the sort order from the input string.
     *
     * @param text  Sort order to find.
     * @return SortOrder  The sort order found.
     */
    public static SortOrder fromString(String text) {
        for (SortOrder sortOrder : SortOrder.values()) {
            if (sortOrder.sortOrder.equalsIgnoreCase(text)) {
                return sortOrder;
            }
        }
        return null;
    }
}
