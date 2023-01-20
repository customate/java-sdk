package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Models an open banking mandate provider (a bank).
 *
 * Date: 19-Jan-23
 * Time: 2:15 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
@ToString
public class OpenBankingMandateProvider extends BaseModel {
    @JsonProperty("country")
    private String country;
    @JsonProperty("provider_id")
    private String providerId;
    @JsonProperty("display_name")
    private String displayName;

    /**
     * Default constructor.
     */
    public OpenBankingMandateProvider() { }

}
