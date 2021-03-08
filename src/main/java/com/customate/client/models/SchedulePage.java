package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Models a page of schedules.
 * 
 * Date: 05-Mar-21
 * Time: 2:24 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class SchedulePage extends BaseModel {

    @JsonProperty("items")
    private List<Schedule> items;
    @JsonProperty("meta")
    private Pagination meta;

    /**
     * Default constructor.
     */
    public SchedulePage() { }

}
