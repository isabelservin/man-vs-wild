package org.tlgcohort.manvswild.Thing;

public class LocationPOJO {

    String name;
    String desc;
    //exits in numerical format
    int northExit;
    int southExit;
    int westExit;
    int eastExit;


    public LocationPOJO(String name, String desc, int northExit, int southExit, int westExit, int eastExit){
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

    public int getNorthExit() {
        return northExit;
    }

    public void setNorthExit(int northExit) {
        this.northExit = northExit;
    }

    public int getSouthExit() {
        return southExit;
    }

    public void setSouthExit(int southExit) {
        this.southExit = southExit;
    }

    public int getWestExit() {
        return westExit;
    }

    public void setWestExit(int westExit) {
        this.westExit = westExit;
    }

    public int getEastExit() {
        return eastExit;
    }

    public void setEastExit(int eastExit) {
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
                '}';
    }
}