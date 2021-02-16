package com.customate.client.enums;

/**
 * Enumeration of titles.
 * 
 * Date: 11-Feb-21
 * Time: 10:25 AM
 *
 * @author Sav Balac
 * @version 1.0
 */
public enum Title {
    mr("mr"),
    mrs("mrs"),
    miss("miss"),
    ms("ms"),
    other("other");

    private String title;

    /**
     * Constructor.
     *
     * @param title  The title as a string.
     */
    Title(String title) {
        this.title = title;
    }

    /**
     * Returns the title as a string.
     */
    @Override
    public String toString() {
        return title;
    }

    /**
     * Gets the title from the input string.
     *
     * @param text  Title to find.
     * @return Title  The title found.
     */
    public static Title fromString(String text) {
        for (Title title : Title.values()) {
            if (title.title.equalsIgnoreCase(text)) {
                return title;
            }
        }
        return null;
    }
}
