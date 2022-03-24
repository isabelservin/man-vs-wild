package org.tlgcohort.manvswild.gridtwo;

import com.fasterxml.jackson.databind.JsonNode;
import org.tlgcohort.manvswild.GameMap;
import org.tlgcohort.manvswild.Location;
import org.tlgcohort.manvswild.datamanagement.DataManagement;
import org.tlgcohort.manvswild.gridtwo.GridTwo;

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
        GameMap gameMap = DataManagement.fromJson(node,GameMap.class);
        List<Location> output = gameMap.getLocations();
        return output;
    }
}