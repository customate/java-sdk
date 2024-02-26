package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

/**
 * Models a verification without a profile (response).
 *
 * Date: 25-Oct-23
 * Time: 3:59 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class VerificationNoProfileResponse extends BaseModel {

    @JsonProperty("status")
    private String status;
    @JsonProperty("external_verification_id")
    private String externalVerificationId;
    @JsonProperty("verification_failure_reasons")
    private List<VerificationFailureReason> verificationFailureReasons;
    @JsonProperty("id")
    private UUID id;

    /**
     * Default constructor.
     */
    public VerificationNoProfileResponse() { }

}
