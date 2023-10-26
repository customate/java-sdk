package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models a verification failure reason (response).
 *
 * Date: 25-Oct-23
 * Time: 3:58 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class VerificationFailureReason extends BaseModel {

    @JsonProperty("global_item_type")
    private String globalItemType;
    @JsonProperty("global_item_failure_reason")
    private String globalItemFailureReason;

    /**
     * Default constructor.
     */
    public VerificationFailureReason() { }

}
