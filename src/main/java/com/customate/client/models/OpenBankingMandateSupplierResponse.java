package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * Models an open banking mandate response from our supplier.
 *
 * Date: 19-Jan-23
 * Time: 5:55 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenBankingMandateSupplierResponse extends BaseModel {

    @JsonProperty("external_mandate_id")
    private UUID externalMandateId;

    @JsonProperty("uri")
    private String uri;

    /**
     * Default constructor.
     */
    public OpenBankingMandateSupplierResponse() { }

}
