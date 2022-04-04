package org.tlgcohort.manvswild.Thing;
import org.tlgcohort.manvswild.Things.Location;
import org.tlgcohort.manvswild.Thing.CommandFeedback;
import org.tlgcohort.manvswild.LocationEngine.LocationEngine;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerActive {

    //Fields
    Location location = new Location();
    CommandFeedback cf;
    List<String> backpack = new ArrayList<>();
    String AXE = "axe";
    String Matches = " matches";
    String Knife = " knife";


    //Constructor
    PlayerActive() {
    super();
    }


    //Business Method || We would likely be using the List<items> keyword because we are getting items per json location but knife is a fill n variable
    public void dropItem(){//player dropitem method
        if(backpack.contains(Knife)){
           backpack.remove(Knife);
        }else{
            cf.inValidEntry("pickup knife");
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

    //Create Driver to test
}
