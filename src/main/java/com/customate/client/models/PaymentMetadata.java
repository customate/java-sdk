package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models metadata within a payment.
 * 
 * Date: 01-Mar-21
 * Time: 4:57 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentMetadata extends BaseModel {

    /**
     * 2-digit ISO country code.
     */
    @JsonProperty("country")
    private String country;
    @JsonProperty("auth_uri")
    private String authUri;
    @JsonProperty("metadata")
    private JsonNode metadata;
    @JsonProperty("webhook_uri")
    private String webhookUri;
    @JsonProperty("redirect_uri")
    private String redirectUri;

    /**
     * Default constructor.
     */
    public PaymentMetadata() { }
}
