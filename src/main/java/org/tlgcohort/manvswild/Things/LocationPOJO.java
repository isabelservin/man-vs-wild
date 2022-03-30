package org.tlgcohort.manvswild.Things;

import java.util.ArrayList;
import java.util.List;

public class LocationPOJO {

    String name;
    String desc;
    List<Item> items;
    List<Food>foods;
    List<NPC>npc;
    String northExit;
    String southExit;
    String westExit;
    String eastExit;

    public LocationPOJO() {
    }

    public LocationPOJO(String name, String desc, List<Item> items,
                        List<Food> foods, List<NPC> npc, String northExit, String southExit, String westExit, String eastExit) {
        this.name = name;
        this.desc = desc;
        this.items = items;
        this.foods = foods;
        this.npc = npc;
        this.northExit = northExit;
        this.southExit = southExit;
        this.westExit = westExit;
        this.eastExit = eastExit;
    }

    // Creating an Exit generator in order to iterate through every location exit.
    public ArrayList<String> allExistsGenerator(){
        ArrayList<String> allExits = new ArrayList<>();
        allExits.add(getNorthExit().toLowerCase());
        allExits.add(getEastExit().toLowerCase());
        allExits.add(getWestExit().toLowerCase());
        allExits.add(getSouthExit().toLowerCase());

        return allExits;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public List<NPC> getNpc() {
        return npc;
    }

    public void setNpc(List<NPC> npc) {
        this.npc = npc;
    }

    public String getNorthExit() {
        return northExit;
    }

    public String getSouthExit() {
        return southExit;
    }

    public String getWestExit() {
        return westExit;
    }

    public String getEastExit() {
        return eastExit;
    }

    @Override
    public String toString() {
        return "LocationPOJO{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", items=" + items +
                ", foods=" + foods +
                ", npc=" + npc +
                ", northExit='" + northExit + '\'' +
                ", southExit='" + southExit + '\'' +
                ", westExit='" + westExit + '\'' +
                ", eastExit='" + eastExit + '\'' +
                '}';
    }
}