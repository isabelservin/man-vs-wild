package org.tlgcohort.manvswild.client;

import org.tlgcohort.manvswild.*;
import org.tlgcohort.manvswild.player.Player;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DriverOne {

    //menu options
    private static final String START_GAME = "Start Game";
    private static final String QUIT = "Quit";

    //class var, so I can call it anywhere in my class
    private static Scanner scanner;

    public static void main(String[] args) {

        GameLogic gl = new GameLogic();
        SplashScreen splashScreen = new SplashScreen();
        splashScreen.displaySplashScreen();
        splashScreen.displayTutorial();



        //add options to main menu
        List<String> mainMenu = new ArrayList<>();
        mainMenu.add(START_GAME);
        mainMenu.add(QUIT);

        //track users choice be declaring an empty string
        String choice = "";

        //while user doesn't select quit then they can keep replaying the game
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

                System.out.println("\nThe game is now starting...............\n");
                System.out.println("Enter your name.....");

                scanner = new Scanner(System.in);
                String playerName = scanner.nextLine();

                System.out.println("How much health would you want to start with ? <Enter a number>");
                int playerHealth = scanner.nextInt();

                // creates player and passes name and heath from user inputs
                Player player = new Player(playerName,playerHealth);

                // Starts Game -> GameLogic
                try {
                    gl.startGame(player);
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }



    }
}
