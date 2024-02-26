package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

/**
 * Models a verification (response from get methods).
 *
 * Date: 26-Feb-24
 * Time: 1:43 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Verification extends BaseModel {

    @JsonProperty("id")
    private UUID id;
    @JsonProperty("data")
    private JsonNode data;
    @JsonProperty("external_verification_id")
    private String externalVerificationId;
    @JsonProperty("verification_status")
    private String verificationStatus;
    @JsonProperty("verification_failure_reasons")
    private String verificationFailureReasons;
    @JsonProperty("client_id")
    private UUID clientId;
    @JsonProperty("profile_id")
    private UUID profileId;

    /**
     * Default constructor.
     */
    public Verification() { }

}
