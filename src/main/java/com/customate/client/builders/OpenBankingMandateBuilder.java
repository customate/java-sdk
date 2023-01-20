package com.customate.client.builders;

import com.customate.client.enums.Currency;
import com.customate.client.enums.OpenBankingMandatePeriod;
import com.customate.client.enums.OpenBankingSchemeId;
import com.customate.client.models.OpenBankingMandateCreate;
import com.customate.client.models.PaymentOpenBankingGbpCreate;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Builds a GBP open banking payment.
 *
 * Date: 01-Mar-21
 * Time: 3:23 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class OpenBankingMandateBuilder {

    private String providerId;
    private String country;
    private Currency currency;
    private String payerName;
    private String payerEmail;
    private String beneficiaryName;
    private long maximumIndividualAmount;
    private long maximumPaymentAmount;
    private OpenBankingMandatePeriod maximumPaymentPeriod;
    private String reference;
    private String redirectUrl;
    private String validFromDate;
    private String validToDate;

    /**
     * Sets the provider ID.
     *
     * @param providerId  Provider ID.
     * @return OpenBankingMandateBuilder  The updated open banking mandate builder.
     */
    public OpenBankingMandateBuilder setProviderId(String providerId) {
        this.providerId = providerId;
        return this;
    }

    /**
     * Sets the country (must be GB).
     *
     * @param country  Country.
     * @return OpenBankingMandateBuilder  The updated open banking mandate builder.
     */
    public OpenBankingMandateBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    /**
     * Sets the currency (must be GBP).
     *
     * @param currency  Currency.
     * @return OpenBankingMandateBuilder  The updated open banking mandate builder.
     */
    public OpenBankingMandateBuilder setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Sets the payer name.
     *
     * @param payerName  Payer name.
     * @return OpenBankingMandateBuilder  The updated open banking mandate builder.
     */
    public OpenBankingMandateBuilder setPayerName(String payerName) {
        this.payerName = payerName;
        return this;
    }

    /**
     * Sets the payer email.
     *
     * @param payerEmail  Payer email.
     * @return OpenBankingMandateBuilder  The updated open banking mandate builder.
     */
    public OpenBankingMandateBuilder setPayerEmail(String payerEmail) {
        this.payerEmail = payerEmail;
        return this;
    }

    /**
     * Sets the beneficiary name.
     *
     * @param beneficiaryName  Beneficiary name.
     * @return OpenBankingMandateBuilder  The updated open banking mandate builder.
     */
    public OpenBankingMandateBuilder setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
        return this;
    }

    /**
     * Sets the maximum individual amount.
     *
     * @param maximumIndividualAmount  Maximum individual amount.
     * @return OpenBankingMandateBuilder  The updated open banking mandate builder.
     */
    public OpenBankingMandateBuilder setMaximumIndividualAmount(long maximumIndividualAmount) {
        this.maximumIndividualAmount = maximumIndividualAmount;
        return this;
    }

    /**
     * Sets the maximum payment amount (in the specified period).
     *
     * @param maximumPaymentAmount  Maximum payment amount (in the specified period).
     * @return OpenBankingMandateBuilder  The updated open banking mandate builder.
     */
    public OpenBankingMandateBuilder setMaximumPaymentAmount(long maximumPaymentAmount) {
        this.maximumPaymentAmount = maximumPaymentAmount;
        return this;
    }

    /**
     * Sets the period the maximum amount applies to.
     *
     * @param maximumPaymentPeriod  The period the maximum amount applies to.
     * @return OpenBankingMandateBuilder  The updated open banking mandate builder.
     */
    public OpenBankingMandateBuilder setMaximumPaymentPeriod(OpenBankingMandatePeriod maximumPaymentPeriod) {
        this.maximumPaymentPeriod = maximumPaymentPeriod;
        return this;
    }

    /**
     * Sets the reference.
     *
     * @param reference  Reference.
     * @return OpenBankingMandateBuilder  The updated open banking mandate builder.
     */
    public OpenBankingMandateBuilder setReference(String reference) {
        this.reference = reference;
        return this;
    }

    /**
     * Sets the redirect URL.
     *
     * @param redirectUrl  Redirect URL.
     * @return OpenBankingMandateBuilder  The updated open banking mandate builder.
     */
    public OpenBankingMandateBuilder setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
        return this;
    }

    /**
     * Sets the valid from date (start of day).
     *
     * @param validFromDate  Valid from date.
     * @return OpenBankingMandateBuilder  The updated open banking mandate builder.
     */
    public OpenBankingMandateBuilder setValidFromDate(String validFromDate) {
        this.validFromDate = validFromDate;
        return this;
    }

    /**
     * Sets the valid to date (end of day).
     *
     * @param validToDate  Valid to date.
     * @return OpenBankingMandateBuilder  The updated open banking mandate builder.
     */
    public OpenBankingMandateBuilder setValidToDate(String validToDate) {
        this.validToDate = validToDate;
        return this;
    }


    /**
     * Builds an open banking mandate.
     *
     * @return OpenBankingMandateCreate  The open banking mandate.
     */
    public OpenBankingMandateCreate build() {
        return new OpenBankingMandateCreate(providerId, country, currency, payerName, payerEmail, beneficiaryName,
                                            maximumIndividualAmount, maximumPaymentAmount, maximumPaymentPeriod,
                                            reference, redirectUrl, validFromDate, validToDate);
    }

}
