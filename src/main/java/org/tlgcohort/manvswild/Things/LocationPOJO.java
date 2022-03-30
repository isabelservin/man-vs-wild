package org.tlgcohort.manvswild.Things;

import java.util.List;

public class LocationPOJO {

    String name;
    String desc;
    String northExit;
    String southExit;
    String westExit;
    String eastExit;
    List<Item> items;

    public LocationPOJO() {
    }

    public LocationPOJO(String name, String desc, String northExit, String southExit, String westExit, String eastExit){
        this.name = name;
        this.desc = desc;
        this.northExit = northExit;
        this.southExit = southExit;
        this.westExit = westExit;
        this.eastExit = eastExit;
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
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