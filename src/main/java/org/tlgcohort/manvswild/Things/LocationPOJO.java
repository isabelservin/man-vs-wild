package org.tlgcohort.manvswild.Things;

import java.util.List;

public class LocationPOJO {

    String name;
    String desc;
    List<Item> items;
    List<Food>foods;
    NPC npc;
    String northExit;
    String southExit;
    String westExit;
    String eastExit;
    private Boolean hasNPC = false;

    public LocationPOJO() {
    }

    public LocationPOJO(String name, String desc, List<Item> items,
                        List<Food> foods, NPC npc, String northExit, String southExit, String westExit, String eastExit) {
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

    public void setNorthExit(String northExit) {
        this.northExit = northExit;
    }

    public String getSouthExit() {
        return southExit;
    }

    public void setSouthExit(String southExit) {
        this.southExit = southExit;
    }

    public String getWestExit() {
        return westExit;
    }

    public void setWestExit(String westExit) {
        this.westExit = westExit;
    }

    public String getEastExit() {
        return eastExit;
    }

    public void setEastExit(String eastExit) {
        this.eastExit = eastExit;
    }

    @Override
    public String toString() {
        return "LocationPOJO{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", northExit=" + northExit +
                ", southExit=" + southExit +
                ", westExit=" + westExit +
                ", eastExit=" + eastExit +
                ", items=" + items +
                '}';
    }
}