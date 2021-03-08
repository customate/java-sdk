package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models the metadata in attributes returned after creating an open banking payment.
 *
 * Date: 02-Mar-21
 * Time: 2:13 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentOpenBankingDataAttributesMetadata extends BaseModel {

    @JsonProperty("webhook_uri")
    private String webhookUri;
    @JsonProperty("redirect_url")
    private String redirectUrl;
    @JsonProperty("auth_uri")
    private String authUri;
    /**
     * ISO 2-digit country code.
     */
    @JsonProperty("country")
    private String country;
    @JsonProperty("metadata")
    JsonNode metadata;

    /**
     * Default constructor.
     */
    public PaymentOpenBankingDataAttributesMetadata() { }

}
