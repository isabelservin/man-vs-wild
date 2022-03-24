package org.tlgcohort.manvswild;

import org.tlgcohort.manvswild.gridone.GridOne;
import org.tlgcohort.manvswild.gridone.GridOneEngine;
import org.tlgcohort.manvswild.gridtwo.GridTwo;
import org.tlgcohort.manvswild.gridtwo.GridTwoEngine;

import java.io.IOException;
import java.util.List;

public class GameLogic {
    public void startGame() throws IOException {
        GridOneEngine gridOne = new GridOneEngine();
        List<Location> gridOneLocation = gridOne.gridOneInformation();
        GridOne access = gridOne.gridOneEngine();

        System.out.println("Started");
        System.out.println("\nYou wake up and realize you are in a tent with no idea how you got there,\n" +
                "and now you hear the sounds of river, only to come out and realize you are in a Jungle!");

        System.out.println("\n*User enters keyword to get information on their location*");
        //TO-DO: user enters keyword to get information on location
        System.out.println("Here is some information on your location\n");
        System.out.println(gridOneLocation.get(0));

        System.out.println("\n*User enters keyword to grab tool*");
        //TO-DO: user enters keyword to pick up firewood
        System.out.println("You picked up " + access.getTools());

        //if user input == go EAST
        //TO-DO user enters keyword to go EAST to the river
        GridTwoEngine gridTwo = new GridTwoEngine();    //loading gridTwo object
        GridTwo gridTwoAccess = gridTwo.gridTwoEngine();
        System.out.println("\n*User enters to go east*");
        System.out.println("This is a really strong current, and so loud I can barely hear anything around me");
        System.out.println("There is a " + gridTwoAccess.getAnimal()+ "!");

        //TO-DO user enters keyword to attack the animal
        System.out.println("\n*User enters to attack the animal*");
        System.out.println("The " + gridTwoAccess.getAnimal() + "'s" + " health is " + gridTwoAccess.getAnimalHealth());


    }
}