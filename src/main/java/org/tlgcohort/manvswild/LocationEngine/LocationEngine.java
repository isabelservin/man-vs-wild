package org.tlgcohort.manvswild.LocationEngine;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.type.LogicalType;
import org.tlgcohort.manvswild.Things.LocationPOJO;
import java.io.File;
import java.io.IOException;

public class LocationEngine {

    //convert to utility class via private
    private LocationEngine(){

    }

    public static LocationPOJO[] locationGenerator(String filePath) throws IOException {
        File file = new File(filePath);

        ObjectMapper objectMapper =new ObjectMapper();
        // these methods are part of the ObjectMapper class and help deal with the data
        //  For example: LocationPOJO has all the arguments it can possibly take, but since basecamp does not
        //  have an animal and other locations do we can just not put anything for NPC for basecamp and it will still run
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES,false);
        objectMapper.coercionConfigFor(LogicalType.Map).setCoercion(CoercionInputShape.EmptyObject, CoercionAction.AsNull);

        //Generating an array of our locations with all the necessary information
        return objectMapper.readValue(file,LocationPOJO[].class);
    }
}