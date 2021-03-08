package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Models a list of non-processing dates (dates that banks cannot process payments on).
 * 
 * Date: 03-Mar-21
 * Time: 4:07 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class NonProcessingDates extends BaseModel {

    @JsonProperty("items")
    private List<Date> items;

    /**
     * Default constructor.
     */
    public NonProcessingDates() { }

}
