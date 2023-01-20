package com.customate.client.models;

import com.customate.client.enums.OpenBankingMandateStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * Models an open banking mandate response when created.
 *
 * Date: 19-Jan-23
 * Time: 5:50 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenBankingMandateResponse extends BaseModel {

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("mandate")
    private OpenBankingMandateData openBankingMandateData;

    @JsonProperty("mandate_response")
    private OpenBankingMandateSupplierResponse openBankingMandateSupplierResponse;

    /**
     * Default constructor.
     */
    public OpenBankingMandateResponse() { }

}
