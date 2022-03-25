package org.tlgcohort.manvswild.player;

import org.tlgcohort.manvswild.Location;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int health = 50;
    private List<String> backpack = new ArrayList<String>();
    private Location currentLocation = new Location();


    public Player(String name, int health) {
        this.name = name;
        this.health = health;
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
}
