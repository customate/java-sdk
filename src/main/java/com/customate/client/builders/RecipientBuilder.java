package com.customate.client.builders;

import com.customate.client.models.Address;
import com.customate.client.models.Recipient;

/**
 * Builds a recipient.
 *
 * Date: 26-Feb-21
 * Time: 1:50 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class RecipientBuilder {

    private String email;
    private Address address;
    private String fullName;

    /**
     * Sets the email address.
     *
     * @param email  Email address.
     * @return RecipientBuilder  Updated recipient builder.
     */
    public RecipientBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * Sets the address.
     *
     * @param address  Address.
     * @return RecipientBuilder  Updated recipient builder.
     */
    public RecipientBuilder setAddress(Address address) {
        this.address = address;
        return this;
    }

    /**
     * Sets the full name.
     *
     * @param fullName  Full name.
     * @return RecipientBuilder  Updated recipient builder.
     */
    public RecipientBuilder setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    /**
     * Builds a recipient.
     *
     * @return Recipient  The recipient.
     */
    public Recipient build() {
        return new Recipient(email, address, fullName);
    }

}
