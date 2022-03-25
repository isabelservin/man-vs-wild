package org.tlgcohort.manvswild;

import org.tlgcohort.manvswild.client.InputParser;
import org.tlgcohort.manvswild.commands.CommandEngine;
import org.tlgcohort.manvswild.gridone.GridOne;
import org.tlgcohort.manvswild.gridone.GridOneEngine;
import org.tlgcohort.manvswild.gridtwo.GridTwo;
import org.tlgcohort.manvswild.gridtwo.GridTwoEngine;
import org.tlgcohort.manvswild.player.Player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class GameLogic {

    public void startGame(Player player) throws IOException {

//        GridOneEngine gridOne = new GridOneEngine();
//        List<Location> gridOneLocation = gridOne.gridOneInformation();
//        GridOne access = gridOne.gridOneEngine();
//
        CommandEngine commandEngine = new CommandEngine();
        int progressionTracker = 0;

        while (!(progressionTracker == 2)) {
            if (progressionTracker == 0) {
                System.out.println("\nHello " + player.getName());
                System.out.println("\nYou wake up and realize you are in a tent with no idea how you got there,\n" +
                        "and now you hear the sounds of river, only to come out and realize you are in a Jungle!");
                commandEngine.displayCommands();

                List<String> inputParser = InputParser.parseInput();
                commandEngine.commandProcessor(inputParser);
                if (inputParser.get(0).contains("go")) {
                    progressionTracker++;
                }
            }
            if (progressionTracker == 1) {

                System.out.println("\nI made it to the river......Is that a zombie !!!!\n");
                commandEngine.displayCommands();
                List<String> inputParserTwo = InputParser.parseInput();
                commandEngine.commandProcessor(inputParserTwo);
                if (inputParserTwo.get(0).equals("go")) {
                    System.out.println("\nEnd demo");
                    progressionTracker++;
                }
            }
        }



        //conditional statement.....


//        command = userInput.nextLine();
//        //System.out.println("\n*User enters keyword to get information on their location*");
//        //TO-DO: user enters keyword to get information on location
//        System.out.println("Here is some information on your location\n");
//        System.out.println(gridOneLocation.get(0));
//
//        System.out.println("\n*User enters keyword to grab tool*");
//        //TO-DO: user enters keyword to pick up firewood
//        System.out.println("You picked up " + access.getTools());
//
//        //if user input == go EAST
//        //TO-DO user enters keyword to go EAST to the river
//        GridTwoEngine gridTwo = new GridTwoEngine();    //loading gridTwo object
//        GridTwo gridTwoAccess = gridTwo.gridTwoEngine();
//        System.out.println("\n*User enters to go east*");
//        System.out.println("This is a really strong current, and so loud I can barely hear anything around me");
//        System.out.println("There is a " + gridTwoAccess.getAnimal()+ "!");
//
//        //TO-DO user enters keyword to attack the animal
//        System.out.println("\n*User enters to attack the animal*");
//        System.out.println("The " + gridTwoAccess.getAnimal() + "'s" + " health is " + gridTwoAccess.getAnimalHealth());

    }
}