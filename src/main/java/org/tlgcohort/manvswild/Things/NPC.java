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

    public void attack(Player player) {
        int inflictedDamage = (getAttackPoints()/ 2);
        int damage = Math.round(inflictedDamage);
        int opponentDamage = player.getHealth() - damage;
        player.setHealth(opponentDamage);
        System.out.println("+------------------------------------------------------------------------------------+");
        System.out.println("\t" + name + " attacked " + player.getName() + "!!\n\t" + name + " inflicted " + damage + " damage!");
        System.out.println("+------------------------------------------------------------------------------------+");

        if(player.getHealth() <= 0){
            System.out.println("+------------------------------------------------------------------------------------+");
            System.out.println("\t" + player.getName() + " is dead.");
            System.out.println("+------------------------------------------------------------------------------------+");

        }
    }

    public void displayStats(){
        System.out.println("\n||==================================================================================||");
        System.out.println("\tOpponent: " + getName() + "\tHealth: " + getHealth());
        System.out.println("||==================================================================================||");

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
