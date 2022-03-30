package org.tlgcohort.manvswild.Things;

public class NPC {
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

    public void setName(String name) {
        this.name = name;
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

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }
}
