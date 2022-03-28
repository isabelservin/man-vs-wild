package org.tlgcohort.manvswild.GameLogic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SplashScreen {

    private static Scanner scanner;

    // Displays Splash Screen from text file
    public void displaySplashScreen(){
        scanner = new Scanner(System.in);
        String userInput = " ";

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/TextFiles/SplashScreen.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n Type Next \n");

        while(!userInput.equalsIgnoreCase("next")){
            userInput = scanner.nextLine();
            }
        }

     // Displays tutorial from text file
    public void displayTutorial(){
        scanner = new Scanner(System.in);
        String userInput = "";

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/TextFiles/Tutorial.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n Type Enter \n");

        while(!userInput.equalsIgnoreCase("enter")){
            userInput = scanner.nextLine();
        }
    }
}
