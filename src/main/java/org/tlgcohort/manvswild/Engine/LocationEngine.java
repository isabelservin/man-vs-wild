package org.tlgcohort.manvswild.Engine;

import com.fasterxml.jackson.databind.JsonNode;
import org.tlgcohort.manvswild.Things.LocationPOJO;
import org.tlgcohort.manvswild.Things.Map;
import org.tlgcohort.manvswild.Things.Inventory;
import org.tlgcohort.manvswild.DataManagement.DataManagement;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LocationEngine {

    DataManagement dm = new DataManagement();
    //File file = new File("src/main/resources/Basecamp.json");

    public LocationPOJO locationGenerator(String filePath) throws IOException {
        File file = new File(filePath);
        JsonNode node = dm.parse(file);
        LocationPOJO location = dm.fromJson(node,LocationPOJO.class);
        return location;
    }

    public List<Inventory> inventoryGenerator(String filePath) throws IOException {
        File file = new File(filePath);
        JsonNode node = dm.parse(file);
        Map gameMap = DataManagement.fromJson(node, Map.class);
        List<Inventory> inventory = gameMap.getInventory();
        return inventory;
    }

}