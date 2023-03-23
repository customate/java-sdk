package com.customate.client.utils;

import com.customate.client.enums.SortOrder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Creates encoded query strings from a list of filters and a sort field & sort order.
 *
 * Date: 17-Mar-23
 * Time: 3:06 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
public class UrlHelper {

    // Encodes a string to UTF-8
    public static String urlEncodeUTF8(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException(e);
        }
    }

    // Builds a query string from a map, with each filter entry encoded to UTF-8, plus a sort field and sort order
    public static String createQueryString(Map<?,?> map, String sortField, SortOrder sortOrder) {
        StringBuilder sb = new StringBuilder();
        if (map.size() > 0 || (!sortField.isEmpty())) {
            sb.append("?");
        }
        for (Map.Entry<?,?> entry : map.entrySet()) {
            if (sb.length() > 1) {
                sb.append("&");
            }
            sb.append("filter[");
            sb.append(String.format("%s]=%s",
                    urlEncodeUTF8(entry.getKey().toString()),
                    urlEncodeUTF8(entry.getValue().toString())
            ));
        }
        if (!sortField.isEmpty()) {
            if (map.size() > 0) {
                sb.append("&");
            }
            sb.append("sort=").append(sortOrder).append(sortField);
        }
        return sb.toString();
    }

}
