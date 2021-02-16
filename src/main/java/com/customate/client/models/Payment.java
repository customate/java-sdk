package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

/**
 * Models a payment.
 *
 * Date: 15-Feb-21
 * Time: 3:21 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class Payment extends BaseModel {

    @JsonProperty("id")
    private UUID id;

    /**
     * Default constructor.
     */
    public Payment() { }
}