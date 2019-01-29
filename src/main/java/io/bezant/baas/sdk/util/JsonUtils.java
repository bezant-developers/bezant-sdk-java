package io.bezant.baas.sdk.util;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.type.CollectionType;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class JsonUtils {
    private final ObjectMapper mapper;

    private JsonUtils() {
        mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(MapperFeature.AUTO_DETECT_GETTERS, true);
        mapper.configure(MapperFeature.AUTO_DETECT_IS_GETTERS, true);
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
    }

    public static JsonUtils getInstance() {
        return new JsonUtils();
    }

    private static ObjectMapper getMapper() {
        return getInstance().mapper;
    }

    public static String toJson(Object object) {
        try {
            return getMapper().writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromJson(String jsonStr, Class<T> cls) {
        try {
            return getMapper().readValue(jsonStr, cls);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromJson(InputStream inputStream, Class<T> cls) {
        try {
            return getMapper().readValue(inputStream, cls);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JsonNode fromJson(InputStream inputStream) {
        try {
            return getMapper().readValue(inputStream, JsonNode.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String toPrettyJson(Object object) {
        try {
            ObjectMapper objectMapper = getMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromJsonToMap(String jsonStr) {
        try {
            return getMapper().readValue(jsonStr, new TypeReference<HashMap<String, Object>>() {
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromJson(String jsonStr, TypeReference<T> typeReference) {
        try {
            return getMapper().readValue(jsonStr, typeReference);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JsonNode fromJson(String json) {
        try {
            return getMapper().readTree(json);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static JsonNode fromJson(Object object) {
        try {
            return getMapper().convertValue(object, JsonNode.class);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static <T extends Collection> T fromJson(String jsonStr, CollectionType collectionType) {
        try {
            return getMapper().readValue(jsonStr, collectionType);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
