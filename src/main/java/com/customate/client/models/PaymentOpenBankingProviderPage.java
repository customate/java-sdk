package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Models a list of open banking providers.
 * 
 * Date: 07-Apr-21
 * Time: 12:36 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentOpenBankingProviderPage extends BaseModel {

    @JsonProperty("results")
    private List<PaymentOpenBankingProvider> results;

    /**
     * Default constructor.
     */
    public PaymentOpenBankingProviderPage() { }

}
