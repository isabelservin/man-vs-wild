package org.tlgcohort.manvswild.Things;

import java.io.Serializable;

public class Food extends Item implements Serializable {
    private String name;
    private int healthPoints;

    public Food() {
    }

    public Food(String name, int healthPoints) {
        this.name = name;
        this.healthPoints = healthPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    @Override
    public String toString() {
        return  name + " : "+ healthPoints;
    }
}
