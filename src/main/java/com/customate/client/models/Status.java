package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models the API status.
 *
 * Date: 08-Feb-21
 * Time: 2:40 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Status extends BaseModel {

    @JsonProperty("version")
    private String version;
    @JsonProperty("status")
    private String status;

    /**
     * Default constructor.
     */
    public Status() { }

}
