package com.customate.client.builders;

import com.customate.client.models.DriverLicence;

/**
 * Builds a driver licence.
 *
 * Date: 10-Feb-21
 * Time: 2:03 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class DriverLicenceBuilder {

    private String number;
    private String postcode;
    private String issueDate;

    /**
     * Sets the driving licence number.
     *
     * @param number  Licence number.
     * @return DriverLicenceBuilder  Updated driver licence builder.
     */
    public DriverLicenceBuilder setNumber(String number) {
        this.number = number;
        return this;
    }

    /**
     * Sets the postcode.
     *
     * @param postcode  Post code.
     * @return DriverLicenceBuilder  Updated driver licence builder.
     */
    public DriverLicenceBuilder setPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    /**
     * Sets the issue date (in YYYY-MM-DD format).
     *
     * @param issueDate  Issue date in YYYY-MM-DD format.
     * @return DriverLicenceBuilder  Updated driver licence builder.
     */
    public DriverLicenceBuilder setIssueDate(String issueDate) {
        this.issueDate = issueDate;
        return this;
    }

    /**
     * Builds a driving licence.
     *
     * @return DriverLicence  The driver licence.
     */
    public DriverLicence build() {
        return new DriverLicence(number, postcode, issueDate);
    }
}
