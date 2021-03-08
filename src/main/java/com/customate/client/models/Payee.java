package com.customate.client.models;

import com.customate.client.enums.Currency;
import com.customate.client.enums.PayeeType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * Models a payee.
 *
 * Date: 15-Feb-21
 * Time: 3:22 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Payee extends BaseModel {

    @JsonProperty("title")
    private String title;
    @JsonProperty("type")
    private PayeeType payeeType;
    @JsonProperty("currency")
    private Currency currency;
    @JsonProperty("data")
    private PayeeData payeeData;
    @JsonProperty("id")
    private UUID id;
    @JsonProperty("metadata")
    private JsonNode metadata;
    @JsonProperty("creation_datetime")
    private String creationDateTime;

    /**
     * Default constructor.
     */
    public Payee() { }
}
