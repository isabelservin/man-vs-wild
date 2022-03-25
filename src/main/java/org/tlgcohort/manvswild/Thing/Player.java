package org.tlgcohort.manvswild.Thing;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int health = 50;
    private List<String> backpack = new ArrayList<String>();
    private Location currentLocation = new Location();

    private LocationPOJO currLocation;

    public Player(String name, int health, LocationPOJO currLocation) {
        this.name = name;
        this.health = health;
        this.currLocation = currLocation;
        backpack.add("matches");
        backpack.add("knife");
        backpack.add("pot");
    }

    public String displayPlayerStats(){
        String stats;
        stats = "\n||=========================================================================================================================||\n" +
                "     Player: " + getName() + "    Health Lvl: " + getHealth() + "    Location: " + getCurrLocation().getName() +
                "\n||=========================================================================================================================||";
        return stats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public List<String> getBackpack() {
        return backpack;
    }

    public void setBackpack(List<String> backpack) {
        this.backpack = backpack;
    }

    public LocationPOJO getCurrLocation() {
        return currLocation;
    }

    public void setCurrLocation(LocationPOJO currLocation) {
        this.currLocation = currLocation;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", backpack=" + backpack +
                ", currLocation=" + currLocation +
                '}';
    }
}
