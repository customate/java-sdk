package com.customate.client.builders;

import com.customate.client.enums.Currency;
import com.customate.client.enums.OpenBankingSchemeId;
import com.customate.client.models.PaymentOpenBankingGbpCreate;
import com.customate.client.models.PaymentOpenBankingMandateCreate;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.UUID;

/**
 * Builds an open banking mandate payment (for GB and GBP only).
 *
 * Date: 19-Jan-23
 * Time: 4:07 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class PaymentOpenBankingMandateBuilder {

    private long amount;
    private String description;
    private Currency currency;
    private JsonNode metadata;
    private String beneficiaryName;
    private UUID mandateId;

    /**
     * Sets the amount.
     *
     * @param amount  Amount.
     * @return PaymentOpenBankingMandateBuilder  The updated open banking mandate payment builder.
     */
    public PaymentOpenBankingMandateBuilder setAmount(long amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Sets the description.
     *
     * @param description  Description.
     * @return PaymentOpenBankingMandateBuilder  The updated open banking mandate payment builder.
     */
    public PaymentOpenBankingMandateBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Sets the currency. Must be GBP.
     *
     * @param currency  Currency.
     * @return PaymentOpenBankingMandateBuilder  The updated open banking mandate payment builder.
     */
    public PaymentOpenBankingMandateBuilder setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Sets the metadata.
     *
     * @param metadata  Metadata.
     * @return PaymentOpenBankingMandateBuilder  The updated open banking mandate payment builder.
     */
    public PaymentOpenBankingMandateBuilder setMetadata(JsonNode metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Sets the beneficiary name.
     *
     * @param beneficiaryName  Beneficiary name.
     * @return PaymentOpenBankingMandateBuilder  The updated open banking mandate payment builder.
     */
    public PaymentOpenBankingMandateBuilder setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
        return this;
    }

    /**
     * Sets the mandate ID.
     *
     * @param mandateId  Mandate ID.
     * @return PaymentOpenBankingMandateBuilder  The updated open banking mandate payment builder.
     */
    public PaymentOpenBankingMandateBuilder setMandateId(UUID mandateId) {
        this.mandateId = mandateId;
        return this;
    }

    /**
     * Builds an open banking mandate payment.
     *
     * @return PaymentOpenBankingMandateCreate  The open banking mandate payment.
     */
    public PaymentOpenBankingMandateCreate build() {
        return new PaymentOpenBankingMandateCreate(amount, description, currency, metadata, beneficiaryName, mandateId);
    }

}
