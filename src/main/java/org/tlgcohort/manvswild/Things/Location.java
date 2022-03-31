package org.tlgcohort.manvswild.Things;

import java.util.ArrayList;
import java.util.List;

public class Location {

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

    public NPC getNpc() {
        return npc;
    }

    public void setNpc(NPC npc) {
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

    public String[] getScripts() {
        return scripts;
    }

    public void setScripts(String[] scripts) {
        this.scripts = scripts;
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
                ", scripts=" + scripts +
                ", northExit='" + northExit + '\'' +
                ", southExit='" + southExit + '\'' +
                ", westExit='" + westExit + '\'' +
                ", eastExit='" + eastExit + '\'' +
                '}';
    }
}