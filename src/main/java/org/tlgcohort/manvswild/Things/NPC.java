package org.tlgcohort.manvswild.Things;

import java.io.Serializable;

public class NPC implements Serializable {
    private String name;
    private int health;
    private int attackPoints;

    public NPC() {
    }

    public NPC(String name, int health, int attackPoints) {
        this.name = name;
        this.health = health;
        this.attackPoints = attackPoints;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackPoints() {
        return attackPoints;
    }


    @Override
    public String toString() {
        return "NPC{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attackPoints=" + attackPoints +
                '}';
    }
}
