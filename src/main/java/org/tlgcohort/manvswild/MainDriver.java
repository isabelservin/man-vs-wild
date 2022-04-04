package org.tlgcohort.manvswild;

import org.tlgcohort.manvswild.GameLogic.Game;
import org.tlgcohort.manvswild.GameLogic.LoadGame;
import org.tlgcohort.manvswild.GameLogic.SplashScreen;

import java.io.IOException;
import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainDriver {
    private static final String SPLASH_PATH = "SplashScreen.txt";
    private static final String TUTORIAL_PATH = "Tutorial.txt";

    //menu options
    private static final String START_GAME = "Start Game";
    private static final String QUIT = "Quit";
    private static final String LOAD_GAME = "Load Game";
    private static Scanner scanner;

    public static void main(String[] args) throws IOException, InputMismatchException{

        SplashScreen.displayScreen(SPLASH_PATH);
        SplashScreen.displayScreen(TUTORIAL_PATH);

        //add options to main menu
        List<String> mainMenu = new ArrayList<>();
        mainMenu.add(START_GAME);
        mainMenu.add(LOAD_GAME);
        mainMenu.add(QUIT);

        scanner = new Scanner(System.in);
        System.out.println("\nHello there, what is your name?");
        String playerName = scanner.next().toUpperCase();

        //track users choice be declaring an empty string
        String choice = "";
        //while user doesn't select quit then they can keep replaying the game
        while(!choice.equalsIgnoreCase(QUIT)){
            try {
                displayMainMenu(mainMenu, playerName, "Select an option>>");
                //capture user's choice as an integer
                scanner = new Scanner(System.in);

                int selectedOpt = scanner.nextInt();

                while (selectedOpt > mainMenu.size()) {
                    displayMainMenu(mainMenu, playerName, "That is not a valid selection!\n\tTry again>>");
                    selectedOpt = scanner.nextInt();
                }

                //capture choice by getting the value at this index
                choice = mainMenu.get(selectedOpt - 1);

                //choice cases
                if (choice.equalsIgnoreCase(START_GAME)) {
                    startingMsg();
                    try {
                        Game.InitGame(playerName);
                        Game.StartGame();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                //FIXME: handle InvalidClassException if user selects LOAD before playing through once!
                //InvalidClassException thrown when no saved game is detected to load
                else if (choice.equalsIgnoreCase(LOAD_GAME)) {
                    try {
                        LoadGame.loading();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (InputMismatchException e){
                System.out.println("\n\tERROR: Must select a NUMBER.");
            }
        }
    }

    public static void displayMainMenu(List<String> menu, String name, String response){
        String header = "\n||======================================||" +
                "\n\tWelcome to Man vs. Wild, " + name + "!!" +
                "\n||======================================||";

        System.out.println(header);
        //print out our main menu options & increment the index of each choice
        int choiceIndex = 1;
        for(String opt : menu){
            System.out.println("\t" + choiceIndex + ") " + opt);
            choiceIndex++;
        }

        String footer = "||======================================||" +
                "\n+----------------------------------------+" +
                "\n\t" + response ;
        System.out.println(footer);
    }

    public static void startingMsg(){
        String header = "\n||=================================================||" +
                "\n\tStarting Game..............." +
                "\n||=================================================||";
        System.out.println(header);
    }
}
