package org.tlgcohort.manvswild.Things;
import org.tlgcohort.manvswild.Things.Player;

import java.io.Serializable;

public class PlayerHealth implements Serializable {


    //Fields
    private static int health = 50;

    static int attackMeter = (int)(Math.random() * 100 -50);//Similar to a fight 50/50 chance of win or lost attackmeter

    //CLIENT ASK: Player Character has some sort of health that can be affected and measured
    //When a player chooses to attack we know they risk losing or gaining health but how much?
    //The method leaves this to chance so players attack at your own risk, Risk level can be adjusted
    public static int winOrLost(){
        for(int i = 0; i < 1; i++)
        attackMeter++;
        health+= attackMeter;
        return health;
    }

    public static void main(String[] args) {
        PlayerHealth ph = new PlayerHealth();
        winOrLost();
        System.out.println("My Health meter is " + health);
    }
}
