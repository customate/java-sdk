package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models a profile verification (response).
 *
 * Date: 05-Feb-21
 * Time: 3:38 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class VerificationResponse extends BaseModel {

    @JsonProperty("is_forced")
    private boolean isForced;
    @JsonProperty("status")
    private String status;

    /**
     * Default constructor.
     */
    public VerificationResponse() { }

}
