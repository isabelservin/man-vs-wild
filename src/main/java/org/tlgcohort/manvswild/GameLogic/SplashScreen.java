package org.tlgcohort.manvswild.GameLogic;

import java.io.*;
import java.util.Scanner;

public class SplashScreen {

    private static Scanner scanner;

    private SplashScreen(){

    }
    // Displays Splash Screen from text file
    public static void displaySplashScreen(){
        scanner = new Scanner(System.in);
        String userInput = " ";
        String fileName = "TextFiles/SplashScreen.txt";
        InputStream is = getFileFromResourceAsStream(fileName);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
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
    public static void displayTutorial(){
        scanner = new Scanner(System.in);
        String userInput = "";
        String fileName = "TextFiles/Tutorial.txt";
        InputStream is = getFileFromResourceAsStream(fileName);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
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

    private static InputStream getFileFromResourceAsStream(String fileName) {
        ClassLoader classLoader = SplashScreen.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
    }



}
