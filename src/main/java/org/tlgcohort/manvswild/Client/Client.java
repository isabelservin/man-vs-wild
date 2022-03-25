package org.tlgcohort.manvswild.Client;

import org.tlgcohort.manvswild.*;
import org.tlgcohort.manvswild.Thing.Player;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {

    //menu options
    private static final String START_GAME = "Start Game";
    private static final String QUIT = "Quit";
    private static Scanner scanner;

    public static void main(String[] args) {

        SplashScreen splashScreen = new SplashScreen();
        splashScreen.displaySplashScreen();
        splashScreen.displayTutorial();

        //add options to main menu
        List<String> mainMenu = new ArrayList<>();
        mainMenu.add(START_GAME);
        mainMenu.add(QUIT);

        scanner = new Scanner(System.in);
        System.out.println("\nHello there, what is your name?");
        String playerName = scanner.next().toUpperCase();

        //track users choice be declaring an empty string
        String choice = "";
        //while user doesn't select quit then they can keep replaying the game
        while(!choice.equalsIgnoreCase(QUIT)){

            System.out.println("\nWelcome " + playerName + "!!");
            displayMainMenu(mainMenu);
            System.out.println("\nSelect an option >> ");

            //capture user's choice as an integer
            scanner = new Scanner(System.in);
            int selectedOpt = scanner.nextInt();

            //capture choice by getting the value at this index
            choice = mainMenu.get(selectedOpt - 1);

            //choice cases
            if(choice.equalsIgnoreCase(START_GAME)){

                System.out.println("\nThe game is now starting...............\n");

                System.out.println("How much health would you want to start with ? <Enter a number>");
                int playerHealth = scanner.nextInt();

                try {
                    Game game = new Game(playerName, playerHealth);
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void displayMainMenu(List<String> menu){
        System.out.println("\n||======================================||");
        //print out our main menu options & increment the index of each choice
        int choiceIndex = 1;
        for(String opt : menu){
            System.out.println("     " + choiceIndex + ") " + opt);
            choiceIndex++;
        }
        System.out.println("||======================================||");
    }
}
