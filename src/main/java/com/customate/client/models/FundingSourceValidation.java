package com.customate.client.models;

import com.customate.client.enums.FundingSourceValidationStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models funding source validation.
 * 
 * Date: 11-Feb-21
 * Time: 4:46 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class FundingSourceValidation extends BaseModel {

    @JsonProperty("status")
    private FundingSourceValidationStatus fundingSourceValidationStatus;
    @JsonProperty("issue_code")
    private String issueCode;
    @JsonProperty("issue_message")
    private String issueMessage;

    /**
     * Default constructor.
     */
    public FundingSourceValidation() { }

    /**
     * Constructor.
     *
     * @param fundingSourceValidationStatus  validation status.
     * @param issueCode  issue code.
     * @param issueMessage  issue message.
     */
    public FundingSourceValidation(FundingSourceValidationStatus fundingSourceValidationStatus, String issueCode, String issueMessage) {
        this.fundingSourceValidationStatus = fundingSourceValidationStatus;
        this.issueCode = issueCode;
        this.issueMessage = issueMessage;
    }
}
