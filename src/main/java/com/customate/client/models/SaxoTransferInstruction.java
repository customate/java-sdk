package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models a Saxo transfer instruction.
 *
 * Date: 04-Mar-21
 * Time: 3:47 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class SaxoTransferInstruction extends BaseModel {

    @JsonProperty("id")
    private String id;

    /**
     * Default constructor.
     */
    public SaxoTransferInstruction() { }

}
