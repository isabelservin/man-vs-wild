package org.tlgcohort.manvswild.Things;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Location implements Serializable {

    private String name;
    private String desc;
    private List<Item> items;
    private List<Food>foods;
    private NPC npc;
    private Boolean hasNPC = false;
    private String[] scripts;

    private String northExit;
    private String southExit;
    private String westExit;
    private String eastExit;

    public Location() {
    }

    public Location(String name, String desc, List<Item> items,
                    List<Food> foods, NPC npc, String[] scripts, String northExit, String southExit, String westExit, String eastExit) {
        this.name = name;
        this.desc = desc;
        this.items = items;
        this.foods = foods;
        this.npc = npc;
        this.scripts = scripts;
        this.northExit = northExit;
        this.southExit = southExit;
        this.westExit = westExit;
        this.eastExit = eastExit;
    }

    // Creating an Exit generator in order to iterate through every location exit.
    public ArrayList<String> allExitsGenerator(){
        ArrayList<String> allExits = new ArrayList<>();
        allExits.add(getNorthExit().toLowerCase());
        allExits.add(getEastExit().toLowerCase());
        allExits.add(getWestExit().toLowerCase());
        allExits.add(getSouthExit().toLowerCase());
        System.out.println(" Exits for location: " + name);// shows exits for location
        allExits.forEach(System.out::println);// prints out location for exits
        System.out.println("____________________");
        return allExits;
    }

    public Boolean presentNPC(){
        if(npc != null){
            hasNPC = true;
        }
        return  hasNPC;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public NPC getNpc() {
        return npc;
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

    public String[] getScripts() {
        return scripts;
    }


    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", items=" + items +
                ", foods=" + foods +
                ", npc=" + npc +
                ", hasNPC=" + hasNPC +
                ", scripts=" + Arrays.toString(scripts) +
                ", northExit='" + northExit + '\'' +
                ", southExit='" + southExit + '\'' +
                ", westExit='" + westExit + '\'' +
                ", eastExit='" + eastExit + '\'' +
                '}';
    }
}