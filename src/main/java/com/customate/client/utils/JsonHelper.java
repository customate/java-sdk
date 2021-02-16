package com.customate.client.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Utility methods for JSON, taken from Customate's payment API.
 *
 * Date: 08-Feb-21
 * Time: 2:40 PM
 *
 * @author Eugene Dymo
 * @version 1.0
 */
public class JsonHelper {
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static JsonNode createEmptyObjectNode() {
        return OBJECT_MAPPER.createObjectNode();
    }
    public static ArrayNode createEmptyArrayNode() {
        return OBJECT_MAPPER.createArrayNode();
    }

    public static <T> T fromJsonNode(JsonNode node, Class<T> clazz) {
        return fromString(toString(node), clazz);
    }

    public static String toString(JsonNode node) {
        try {
            if (node == null) {
                return null;
            }
            return OBJECT_MAPPER.writeValueAsString(node);
        } catch (IOException e) {
            throw new IllegalArgumentException(String.format("The given string value: %s object cannot be transformed. Exception: %s",
                    "node", e.getMessage()));
        }
    }

    public static <T> T fromString(String string, Class<T> clazz) {
        try {
            if (string == null) {
                return null;
            }
            return OBJECT_MAPPER.readValue(string, clazz);
        } catch (IOException e) {
            throw new IllegalArgumentException(String.format("The given string value: %s cannot be transformed to %s object. Exception: %s",
                    string, clazz.getSimpleName(), e.getMessage()));
        }
    }

    public static String toString(Object value) {
        String result = null;
        try {
            if (value != null) {
                if (value instanceof String) {
                    result = (String) value;
                } else {
                    result = OBJECT_MAPPER.writeValueAsString(value);
                }
            }
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("The given Json object value: "
                    + value + " cannot be transformed to a String");
        }
        return result;
    }

    public static JsonNode toJsonNode(String value) {
        try {
            return OBJECT_MAPPER.readTree(value);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static JsonNode toJsonNode(Object value) {
        return toJsonNode(toString(value));
    }

    public static ArrayNode toArrayNode(String value) {
        try {
            return (ArrayNode) OBJECT_MAPPER.readTree(value);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }


    public static JsonNode toJsonNode(Map value) {
        return OBJECT_MAPPER.valueToTree(value);
    }

    public static byte[] toByteArray(Object object) throws JsonProcessingException {
        return OBJECT_MAPPER.writeValueAsBytes(object);
    }

    public static <T> T clone(T value) {
        if (value == null) {
            return null;
        }
        return fromString(toString(value), (Class<T>) value.getClass());
    }

    public static boolean areEqual(Object one, Object another) {
        if (one == another) {
            return true;
        }
        if (one == null || another == null) {
            return false;
        }
        return toJsonNode(toString(one)).equals(toJsonNode(toString(another)));
    }

    public static JsonNode getObjectByPath(JsonNode object, String name) {
        String[] parts = name.split("\\.");
        JsonNode cursor = object;
        for (String part : parts) {
            if (cursor != null && cursor.isObject()) {
                if ((cursor).has(part)) {
                    cursor = cursor.get(part);
                } else {
                    cursor = null;
                    break;
                }
            }
        }
        return cursor;
    }

    public static ArrayNode getArrayByPath(JsonNode object, String name) {
        String[] parts = name.split("\\.");
        JsonNode cursor = object;
        ArrayNode result = null;
        for (String part : parts) {
            if (cursor != null && cursor.isObject()) {
                if ((cursor).has(part)) {
                    cursor = cursor.get(part);
                } else {
                    break;
                }
            }
        }
        if (cursor != null && cursor.isArray()) {
            result = (ArrayNode) cursor;
        }
        return result;
    }

    public static boolean hasField(JsonNode object, String fieldName) {
        return object != null && object.has(fieldName);
    }

    public static String getStringField(JsonNode object, String fieldName) {
        String result = "";
        if (object != null && object.hasNonNull(fieldName)) {
            result = object.get(fieldName).textValue();
        }
        return result;
    }

    public static String getStringFieldByPath(JsonNode object, String path) {
        String result = "";
        if (object != null) {
            JsonNode field = getObjectByPath(object, path);
            if (field != null && field.isTextual()) {
                result = field.asText();
            }
        }
        return result;
    }

    public static int getIntField(JsonNode object, String fieldName) {
        return getIntField(object, fieldName, 0);
    }

    public static int getIntField(JsonNode object, String fieldName, int defaultValue) {
        int result = defaultValue;
        if (object != null && object.hasNonNull(fieldName)) {
            result = object.get(fieldName).intValue();
        }
        return result;
    }

    public static long getLongField(JsonNode object, String fieldName) {
        long result = 0;
        if (object != null && object.hasNonNull(fieldName)) {
            result = object.get(fieldName).longValue();
        }
        return result;
    }

    public static double getDoubleField(JsonNode object, String fieldName) {
        double result = 0;
        if (object != null && object.hasNonNull(fieldName)) {
            result = object.get(fieldName).doubleValue();
        }
        return result;
    }

    public static void addStringField(JsonNode object, String fieldName, String value) {
        if (!StringUtils.isEmpty(value)) {
            if (object instanceof ObjectNode) {
                ((ObjectNode) object).put(fieldName, value);
            } else {
                throw new IllegalArgumentException("JsonHelper.addObjectField received not ObjectNode");
            }
        }
    }

    public static void addIntegerField(JsonNode object, String fieldName, Integer value) {
        if (value != null) {
            if (object instanceof ObjectNode) {
                ((ObjectNode) object).put(fieldName, value);
            } else {
                throw new IllegalArgumentException("JsonHelper.addIntegerField received not ObjectNode");
            }
        }
    }

    public static void addLongField(JsonNode object, String fieldName, Long value) {
        if (value != null) {
            if (object instanceof ObjectNode) {
                ((ObjectNode) object).put(fieldName, value);
            } else {
                throw new IllegalArgumentException("JsonHelper.addLongField received not ObjectNode");
            }
        }
    }

    public static void addObjectField(JsonNode object, String fieldName, JsonNode value) {
        if (value != null) {
            if (object instanceof ObjectNode) {
                ((ObjectNode) object).set(fieldName, value);
            } else {
                throw new IllegalArgumentException("JsonHelper.addObjectField received not ObjectNode");
            }
        }
    }

    public static void addObjectField(ArrayNode array, JsonNode value) {
        array.add(value);
    }

    public static void addArrayField(JsonNode object, String fieldName, JsonNode value) {
        if (value != null) {
            addObjectField(object, fieldName, value);
        }
    }

    public static void addDoubleField(JsonNode object, String fieldName, Double value) {
        if (value != null) {
            if (object instanceof ObjectNode) {
                ((ObjectNode) object).put(fieldName, value);
            } else {
                throw new IllegalArgumentException("JsonHelper.addDoubleField received not ObjectNode");
            }
        }
    }

    public static void removeObjectField(JsonNode object, String fieldName) {
        if (object instanceof ObjectNode) {
            removeObjectField((ObjectNode) object, fieldName);
        } else {
            throw new IllegalArgumentException("JsonHelper.removeObjectField received not ObjectNode");
        }
    }

    private static void removeObjectField(ObjectNode object, String fieldName) {
        object.remove(fieldName);
    }

    public static JsonNode merge(JsonNode mainNode, JsonNode updateNode) {
        Iterator<String> fieldNames = updateNode.fieldNames();
        while (fieldNames.hasNext()) {
            String fieldName = fieldNames.next();
            JsonNode jsonNode = mainNode.get(fieldName);
            // if field exists and is an embedded object
            if (jsonNode != null && jsonNode.isObject()) {
                merge(jsonNode, updateNode.get(fieldName));
            } else {
                if (mainNode instanceof ObjectNode) {
                    // Overwrite field
                    JsonNode value = updateNode.get(fieldName);
                    ((ObjectNode) mainNode).set(fieldName, value);
                }
            }
        }
        return mainNode;
    }
}