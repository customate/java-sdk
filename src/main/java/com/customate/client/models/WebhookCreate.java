package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models a webhook (for creation).
 *
 * Date: 26-Feb-21
 * Time: 5:58 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebhookCreate extends BaseModel {

    @JsonProperty("callback_url")
    private String callbackUrl;
    @JsonProperty("is_enabled")
    private boolean isEnabled;

    /**
     * Default constructor.
     */
    public WebhookCreate() { }

    /**
     * Constructor.
     *
     * @param callbackUrl  Callback URL.
     * @param isEnabled  Is enabled.
     */
    public WebhookCreate(String callbackUrl, boolean isEnabled) {
        this.callbackUrl = callbackUrl;
        this.isEnabled = isEnabled;
    }

}
