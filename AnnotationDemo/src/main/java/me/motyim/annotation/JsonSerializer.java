package me.motyim.annotation;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

public class JsonSerializer {
    public String serialize(Object object) throws JsonSerializeException {
        try {
            Class<?> objectClass = requireNonNull(object).getClass();
            Map<String, Object> jsonElements = new HashMap<>();
            for (Field field : objectClass.getDeclaredFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(JsonField.class)) {
                    Class<?> type = field.getType();
                    Object value = field.get(object);
                    jsonElements.put(getSerializedKey(field), toJsonObject(value, type));
                }
            }
            return toJsonString(jsonElements);
        } catch (IllegalAccessException e) {
            throw new JsonSerializeException(e.getMessage());
        }
    }

    private String toJsonObject(Object value, Class<?> type) {
        StringBuilder sb = new StringBuilder();
        if (type.isPrimitive() || value instanceof String) {
            sb.append(getPrimative(value));
        } else if (value.getClass().isArray()) {
            sb.append("[");
            int length = Array.getLength(value);
            for (int i = 0; i < length; i++) {
                Object arrayElement = Array.get(value, i);
                sb.append(getPrimative(arrayElement));
                if (i != length - 1)
                    sb.append(",");
            }
            sb.append("]");
        } else {
            sb.append("Object");
        }
        return sb.toString();
    }

    private String toJsonString(Map<String, Object> jsonMap) {
        String elementsString = jsonMap.entrySet()
                .stream()
                .map(entry -> "\"" + entry.getKey() + "\":" + entry.getValue())
                .collect(Collectors.joining(","));
        return "{" + elementsString + "}";
    }

    private static String getSerializedKey(Field field) {
        String annotationValue = field.getAnnotation(JsonField.class).value();
        return annotationValue.isEmpty() ? field.getName() : annotationValue;
    }

    private static String getPrimative(Object obj) {
        if (obj instanceof String)
            return "\"" + obj.toString() + "\"";
        else return obj.toString();
    }
}
