package org.tlgcohort.manvswild.gridone;

import com.fasterxml.jackson.databind.JsonNode;
import org.tlgcohort.manvswild.GameMap;
import org.tlgcohort.manvswild.Location;
import org.tlgcohort.manvswild.dataManagement.DataManagement;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class GridOneEngine {
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
        GameMap gameMap = DataManagement.fromJson(node,GameMap.class);
        List<Location> output = gameMap.getLocations();
        return output;
    }
}
