package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * Models a data item containing a type and ID.
 *
 * Date: 02-Mar-21
 * Time: 2:28 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data extends BaseModel {

    @JsonProperty("type")
    private String type;
    @JsonProperty("id")
    private UUID id;

    /**
     * Default constructor.
     */
    public Data() { }

}
