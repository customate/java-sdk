package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models a date.
 *
 * Date: 03-Mar-21
 * Time: 4:04 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Date extends BaseModel {

    @JsonProperty("date")
    private String date;

    /**
     * Default constructor.
     */
    public Date() { }

}
