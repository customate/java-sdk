package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models a title (name) for funding sources and payees.
 *
 * Date: 26-Feb-21
 * Time: 12:22 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class TitleName extends BaseModel {

    @JsonProperty("title")
    private String titleName;

    /**
     * Default constructor.
     */
    public TitleName() { }

    public TitleName(String titleName) {
        this.titleName = titleName;
    }
}
