package org.tlgcohort.manvswild.LocationEngine;

import com.fasterxml.jackson.databind.JsonNode;
import org.tlgcohort.manvswild.Things.LocationPOJO;
import org.tlgcohort.manvswild.Things.Map;
import org.tlgcohort.manvswild.Things.Item;
import org.tlgcohort.manvswild.DataManagement.DataManagement;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LocationEngine {

    //convert to utility class via private
    private LocationEngine(){

    }

    public static LocationPOJO locationGenerator(String filePath) throws IOException {
        File file = new File(filePath);
        JsonNode node = DataManagement.parse(file);
        return DataManagement.fromJson(node, LocationPOJO.class);
    }

    public static List<Item> inventoryGenerator(String filePath) throws IOException {
        File file = new File(filePath);
        JsonNode node = DataManagement.parse(file);
        Map gameMap = DataManagement.fromJson(node, Map.class);
        return gameMap.getInventory();
    }

}