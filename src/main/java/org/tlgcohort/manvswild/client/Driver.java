package org.tlgcohort.manvswild.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.tlgcohort.manvswild.client.Direction.NOEXIT;


public class Driver {
    //menu options
    private static final String START_GAME = "Start Game";
    private static final String QUIT = "Quit";

    //class var so I can call it anywhere in my class
    private static Scanner scanner;

    //world map
    private static List<Location> worldMap;

    public static void main(String[] args) {
        worldMap = new ArrayList<>();
        worldMap.add(new Location("Basecamp", "errie and abandoned camp site with a lingering fire to warm your tired soul", NOEXIT, 1, NOEXIT, 3));
        worldMap.add(new Location("Mountains", "serrated vampire-white mountains loomed in front of you. Sheathed in frost biting snow.", 1, NOEXIT, NOEXIT, 2));
        worldMap.add(new Location("Forest", "the dark forest trees are now staring at you like silent sentries. Gloomy scrubs hid dangerous creatures. The musty air makes it  difficult to breathe. The forest is old and otherworldly.",3, NOEXIT, 1, NOEXIT));
        worldMap.add(new Location("Caves", "slkdjlkas", NOEXIT, 2, 0, NOEXIT));

        //add options to main menu
        List<String> mainMenu = new ArrayList<>();
        mainMenu.add(START_GAME);
        mainMenu.add(QUIT);

        //track users choice be declaring an empty string
        String choice = "";

        //while user doesnt select quit then they can keep replaying the game
        while(!choice.equalsIgnoreCase(QUIT)){
            System.out.println("\nWelcome Survivor!!!");
            System.out.println("\n***********");

            //print out our main menu options & increment the index of each choice
            int choiceIndex = 1;
            for(String opt : mainMenu){
                System.out.println(choiceIndex + ") " + opt);
                choiceIndex++;
            }

            //prompt for user to select from the main menu
            System.out.println("**********");
            System.out.println("\nSelect an option>> ");

            //capture user's choice as an integer
            scanner = new Scanner(System.in);
            int selectedOpt = scanner.nextInt();

            //capture choice by getting the value at this index
            choice = mainMenu.get(selectedOpt - 1);

            //choice cases
            if(choice.equalsIgnoreCase(START_GAME)){

                //game logic here
                // startGame();
                System.out.println("\nThe game is now starting...............");
            }

        }

    }
}