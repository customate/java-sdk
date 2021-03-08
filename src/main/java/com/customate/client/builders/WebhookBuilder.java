package com.customate.client.builders;

import com.customate.client.models.WebhookCreate;

/**
 * Builds a webhook.
 *
 * Date: 26-Feb-21
 * Time: 4:39 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class WebhookBuilder {

    private String callbackUrl;
    private boolean isEnabled;

    /**
     * Sets the callback URL.
     *
     * @param callbackUrl  Callback URL.
     * @return WebhookBuilder  Updated webhook builder.
     */
    public WebhookBuilder setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    /**
     * Sets if the webhook is enabled.
     *
     * @param isEnabled  Is enabled.
     * @return WebhookBuilder  Updated webhook builder.
     */
    public WebhookBuilder setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
        return this;
    }

    /**
     * Builds a webhook.
     *
     * @return WebhookCreate  The webhook.
     */
    public WebhookCreate build() {
        return new WebhookCreate(callbackUrl, isEnabled);
    }

}
