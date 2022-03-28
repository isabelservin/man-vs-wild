package org.tlgcohort.manvswild.Things;

import java.util.List;

public class Map {

    private String gameMap;
    private List<Location> locations;

    public String getGameMap() {
        return gameMap;
    }

    public void setGameMap(String gameMap) {
        this.gameMap = gameMap;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}