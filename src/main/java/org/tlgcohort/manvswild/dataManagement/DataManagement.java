package org.tlgcohort.manvswild.dataManagement;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DataManagement {
//    public Location readValue() {
//        Location location = null;
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            File file = new File("src/main/java/locations.json");
//            location = mapper.readValue(file, Location.class);
//            System.out.println(location.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return location;
//    }
    private static ObjectMapper mapper = getDefaultObjectMapper();
    private static ObjectMapper getDefaultObjectMapper(){
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES,false);
        return defaultObjectMapper;
    }

    public static JsonNode parse(File file) throws IOException {
        return mapper.readTree(file);
    }
    public static <A> A fromJson(JsonNode node, Class<A> clazz) throws JsonProcessingException {
        return mapper.treeToValue(node,clazz);
    }
}
