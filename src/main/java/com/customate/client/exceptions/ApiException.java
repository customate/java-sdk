package com.customate.client.exceptions;

/**
 * Custom exception for errors returned by the API.
 * 
 * Date: 10-Feb-21
 * Time: 11:02 AM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class ApiException extends Exception {

    /**
     * Default constructor.
     */
    public ApiException() { }

    /**
     * Constructor.
     * 
     * @param message  Error message.
     */
    public ApiException(String message) {
        super(message);
    }

}
