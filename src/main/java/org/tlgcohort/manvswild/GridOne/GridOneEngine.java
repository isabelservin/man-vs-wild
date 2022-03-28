package org.tlgcohort.manvswild.GridOne;

import com.fasterxml.jackson.databind.JsonNode;
import org.tlgcohort.manvswild.Things.Map;
import org.tlgcohort.manvswild.Things.Location;
import org.tlgcohort.manvswild.DataManagement.DataManagement;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class GridOneEngine {

    private String name;

    public GridOne gridOneEngine() throws IOException {
        DataManagement dm = new DataManagement();
        File file = new File("src/main/resources/gridOne.json");
        JsonNode node = dm.parse(file);
        GridOne g1 = dm.fromJson(node,GridOne.class);
        return g1;
    }

    public List<Location> gridOneInformation() throws IOException {
        DataManagement dm = new DataManagement();
        File file = new File("src/main/resources/locations.json");
        JsonNode node = dm.parse(file);
        Map gameMap = DataManagement.fromJson(node, Map.class);
        List<Location> output = gameMap.getLocations();
        return output;
    }

}