package org.tlgcohort.manvswild.Thing;

import org.tlgcohort.manvswild.Thing.Location;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerActive {

    //Fields
    List<String> backpack = new ArrayList<>();
    String AXE = "axe";
    String Matches = " matches";
    String Knife = " knife";


    //Constructor
    PlayerActive() {

    }


    //Business Method
    public void useDropGet() {

        Scanner scanner = new Scanner(System.in);
        System.out.println(" There are weapons on the ground" + "\n" + " give the pick up item command to put them in your backpack");
        String command = scanner.nextLine();

        if (command.equalsIgnoreCase("pickup item")) {//player gets items
            backpack.add(Knife);
            backpack.add(Matches);
            backpack.add(AXE);
            System.out.println("Iventory: You have " + backpack + "in your  backpack");
            System.out.println("There is an animal in the cave use your knife");
            command = scanner.nextLine();

            if (command.equalsIgnoreCase("use knife")) {// player uses and drop items
                backpack.remove(Knife);
                System.out.println("You have removed knife from your backpack");
                System.out.println("Inventory of backpack:" + backpack);
                System.out.println("Put knife back into backpack");
                if(!backpack.contains(Knife)){ //player picks up knife again
                    System.out.println("putting knife int backpack");
                    backpack.add(Knife);
                    System.out.println("Inventory of backpack:" + backpack);
                }
            }
        }
    }

    public static void main(String[] args) {
        PlayerActive pa = new PlayerActive();
        pa.useDropGet();
    }
}
