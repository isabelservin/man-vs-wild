package org.tlgcohort.manvswild.Thing;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerActive {

    //Fields
    List<String> backpack = new ArrayList<>();
    String AXE = "axe";
    String Matches = " matches";
    String Knife = " knife";
    String Item = "item";

    //Constructor
    PlayerActive() {

    }


    //Business Method
    public void dropItem(){//player dropitem method
        if(backpack.contains(Knife)){
           backpack.remove(Knife);
        }else{
            System.out.println("You have already dropped Item");
            System.out.println(backpack);
        }
    }
    public void pickupItem(){//player pickup method
        if(!backpack.contains(Knife)){
            backpack.add(Knife);
        }else{
            System.out.println("You already have a Knife in your backpack");
        }
    }
    public void useItem(){//player useitem method
        System.out.println("player is using item");
    }

    public void useDropGet() {//methods being used in scenario

        Scanner scanner = new Scanner(System.in);
        System.out.println(" There are weapons on the ground" + "\n" + " give the pick up knife command to put it in your backpack");
        String command = scanner.nextLine();

        if(command.equalsIgnoreCase("pickup knife")) {
            pickupItem();
            System.out.println(backpack);
            useItem();
            System.out.println("drop knife command will drop knife");
            command = scanner.nextLine();
            if (command.equalsIgnoreCase("drop knife")) {
                dropItem();
                System.out.println(backpack + "backpack is empty");
            }

        }

    }

    public static void main(String[] args) {
        PlayerActive pa = new PlayerActive();
        pa.useDropGet();
        pa.pickupItem();
    }
}
