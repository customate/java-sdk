package com.customate.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Models pagination.
 * 
 * Date: 05-Feb-21
 * Time: 3:01 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pagination extends BaseModel {

    @JsonProperty("pagination")
    private PaginationData paginationData;

    /**
     * Default constructor.
     */
    public Pagination() { }

}
