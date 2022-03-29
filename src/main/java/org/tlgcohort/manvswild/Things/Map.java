package org.tlgcohort.manvswild.Things;

import java.util.List;

public class Map {

    //private String name;
    private List<Inventory> inventory;

    public List<Inventory> getInventory() {
        return inventory;
    }

    public void setInventory(List<Inventory> inventory) {
        this.inventory = inventory;
    }
}