package org.tlgcohort.manvswild.GridTwo;

import com.fasterxml.jackson.databind.JsonNode;
import org.tlgcohort.manvswild.Thing.Map;
import org.tlgcohort.manvswild.Thing.Location;
import org.tlgcohort.manvswild.DataManagement.DataManagement;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class GridTwoEngine {
    public GridTwo gridTwoEngine() throws IOException { //returning a gridTwo object to be able to access GridTwo
        DataManagement dm = new DataManagement();
        File file = new File("src/main/resources/gridTwo.json");    //grabbing appropriate file
        JsonNode node = dm.parse(file);
        GridTwo g2 = dm.fromJson(node,GridTwo.class);
        return g2;
    }

    public List<Location> gridTwoInformation() throws IOException {
        DataManagement dm = new DataManagement();
        File file = new File("src/main/resources/locations.json");
        JsonNode node = dm.parse(file);
        Map gameMap = DataManagement.fromJson(node, Map.class);
        List<Location> output = gameMap.getLocations();
        return output;
    }
}