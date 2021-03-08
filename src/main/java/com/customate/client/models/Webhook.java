package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * Models a webhook.
 *
 * Date: 26-Feb-21
 * Time: 4:20 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Webhook extends BaseModel {

    @JsonProperty("id")
    private UUID id;
    @JsonProperty("callback_url")
    private String callbackUrl;
    @JsonProperty("is_enabled")
    private boolean isEnabled;

    /**
     * Default constructor.
     */
    public Webhook() { }

    /**
     * Constructor.
     *
     * @param callbackUrl  Callback URL.
     * @param isEnabled  Is enabled.
     */
    public Webhook(String callbackUrl, boolean isEnabled) {
        this.callbackUrl = callbackUrl;
        this.isEnabled = isEnabled;
    }

}
