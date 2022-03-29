package org.tlgcohort.manvswild.Things;

public class Inventory {
    private String name;
    private int powerLevel;

    public Inventory() {
    }

    public Inventory(String name, int powerLevel) {
        this.name = name;
        this.powerLevel = powerLevel;
    }

    public String getName() {
        return name;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "name='" + name + '\'' +
                ", powerLevel=" + powerLevel +
                '}';
    }
}