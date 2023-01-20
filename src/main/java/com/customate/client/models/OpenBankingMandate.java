package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.customate.client.enums.OpenBankingMandateStatus;
import java.util.UUID;

/**
 * Models an open banking mandate.
 *
 * Date: 18-Jan-23
 * Time: 2:50 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenBankingMandate extends BaseModel {

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("data")
    private OpenBankingMandateData openBankingMandateData;

    @JsonProperty("status")
    private OpenBankingMandateStatus openBankingMandateStatus;

    /**
     * Default constructor.
     */
    public OpenBankingMandate() { }

}
