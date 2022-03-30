package org.tlgcohort.manvswild;

import org.tlgcohort.manvswild.GameLogic.Game;
import org.tlgcohort.manvswild.GameLogic.SplashScreen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainDriver {

    //menu options
    private static final String START_GAME = "Start Game";
    private static final String QUIT = "Quit";
    private static Scanner scanner;

    public static void main(String[] args) throws IOException {

        SplashScreen.displaySplashScreen();
        SplashScreen.displayTutorial();

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

            displayMainMenu(mainMenu, playerName);

            //capture user's choice as an integer
            scanner = new Scanner(System.in);
            int selectedOpt = scanner.nextInt();

            //capture choice by getting the value at this index
            choice = mainMenu.get(selectedOpt - 1);

            //choice cases
            if(choice.equalsIgnoreCase(START_GAME)){
                startingMsg();
                int playerHealth = scanner.nextInt();

                //initialize & start game
                try {
                    Game.InitGame(playerName,playerHealth);
                    Game.StartGame();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void displayMainMenu(List<String> menu, String name){
        String welcomeMsg = "\n||======================================||" +
                "\n     Welcome to Man vs. Wild, " + name + "!!";
        System.out.println(welcomeMsg);

        System.out.println("||======================================||");

        //print out our main menu options & increment the index of each choice
        int choiceIndex = 1;
        for(String opt : menu){
            System.out.println("     " + choiceIndex + ") " + opt);
            choiceIndex++;
        }
        System.out.println("||======================================||");
        System.out.println("+----------------------------------------+");
        System.out.println("     Select an option>> ");
    }

    public static void startingMsg(){
        System.out.println("\n||=================================================||");
        System.out.println("     Starting Game...............");
        System.out.println("||=================================================||");

        System.out.println("+---------------------------------------------------+");
        System.out.println("     Choose Health Level (Enter a number)>>");

    }
}
