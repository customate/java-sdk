package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Models an open banking provider (a bank).
 *
 * Date: 07-Apr-21
 * Time: 12:32 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
@ToString
public class PaymentOpenBankingProvider extends BaseModel {
    @JsonProperty("provider_id")
    private String providerId;
    @JsonProperty("logo_url")
    private String logoUrl;
    @JsonProperty("icon_url")
    private String iconUrl;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("country")
    private String country;
    @JsonProperty("single_immediate_payment_schemes")
    private List<PaymentOpenBankingProviderScheme> paymentOpenBankingProviderSchemes;

    /**
     * Default constructor.
     */
    public PaymentOpenBankingProvider() { }

}
