package com.customate.client.builders;

import com.customate.client.models.FundingSourceAddress;
import com.customate.client.models.FundingSourceUpdatePayer;
import com.customate.client.models.PayeeAddress;
import com.customate.client.models.PayeeUpdateRecipient;

/**
 * Builds a recipient for updating a payee.
 *
 * Date: 13-Jun-22
 * Time: 16:16 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class PayeeRecipientUpdateBuilder {

    private String email;
    private PayeeAddress payeeAddress;

    /**
     * Sets the email.
     *
     * @param email  Email.
     * @return FundingSourcePayerBuilder  Updated funding source payer builder.
     */
    public PayeeRecipientUpdateBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * Sets the funding source address.
     *
     * @param payeeAddress  Funding source address.
     * @return FundingSourcePayerBuilder  Updated funding source payer builder.
     */
    public PayeeRecipientUpdateBuilder setPayeeAddress(PayeeAddress payeeAddress) {
        this.payeeAddress = payeeAddress;
        return this;
    }

    /**
     * Builds a funding source payer for update.
     *
     * @return PayeeUpdateRecipient  Updated payee recipient builder.
     */
    public PayeeUpdateRecipient build() {
        return new PayeeUpdateRecipient(email, payeeAddress);
    }
}
