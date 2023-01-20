package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Models a list of open banking mandate providers.
 * 
 * Date: 19-Jan-23
 * Time: 2:17 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenBankingMandateProviderPage extends BaseModel {

    @JsonProperty("results")
    private List<OpenBankingMandateProvider> results;

    /**
     * Default constructor.
     */
    public OpenBankingMandateProviderPage() { }

}
