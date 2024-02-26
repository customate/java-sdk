package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

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
    @JsonProperty("verification_id")
    private String verificationId;
    @JsonProperty("verification_failure_reasons")
    private List<VerificationFailureReason> verificationFailureReasons;
    @JsonProperty("id")
    private UUID id;

    /**
     * Default constructor.
     */
    public VerificationResponse() { }

}
