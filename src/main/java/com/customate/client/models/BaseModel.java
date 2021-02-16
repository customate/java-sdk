package com.customate.client.models;

import com.customate.client.utils.JsonHelper;

/**
 * Ancestor of all models.
 *
 * Date: 11-Feb-21
 * Time: 3:28 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class BaseModel {

    /**
     * Returns the object as a JSON string.
     *
     * @return String  JSON.
     */
    public String asJson() {
        return JsonHelper.toString(this);
    }
}
