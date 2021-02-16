package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models funding source title.
 *
 * Date: 12-Feb-21
 * Time: 5:47 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class FundingSourceTitle extends BaseModel {

    @JsonProperty("title")
    private String title;

    /**
     * Default constructor.
     */
    public FundingSourceTitle() { }

    public FundingSourceTitle(String title) {
        this.title = title;
    }
}
