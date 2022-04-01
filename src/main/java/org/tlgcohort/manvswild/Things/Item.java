package org.tlgcohort.manvswild.Things;

import java.io.Serializable;

public class Item implements Serializable {
    private String name;
    private int powerLevel;

    public Item() {
    }

    public Item(String name, int powerLevel) {
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