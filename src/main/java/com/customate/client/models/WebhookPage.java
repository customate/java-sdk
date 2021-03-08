package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Models a page of webhooks.
 * 
 * Date: 26-Feb-21
 * Time: 4:26 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebhookPage extends BaseModel {

    @JsonProperty("items")
    private List<Webhook> items;
    @JsonProperty("meta")
    private Pagination meta;

    /**
     * Default constructor.
     */
    public WebhookPage() { }

}
