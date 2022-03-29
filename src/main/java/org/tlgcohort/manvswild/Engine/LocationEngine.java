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

    private String name;

    public LocationPOJO locationGenerator() throws IOException {
        DataManagement dm = new DataManagement();
        File file = new File("src/main/resources/Basecamp.json");
        JsonNode node = dm.parse(file);
        LocationPOJO g1 = dm.fromJson(node,LocationPOJO.class);
        return g1;
    }

    public List<Inventory> inventoryInformation() throws IOException {
        DataManagement dm = new DataManagement();
        File file = new File("src/main/resources/Basecamp.json");
        JsonNode node = dm.parse(file);
        Map gameMap = DataManagement.fromJson(node, Map.class);
        List<Inventory> output = gameMap.getInventory();
        return output;
    }

}