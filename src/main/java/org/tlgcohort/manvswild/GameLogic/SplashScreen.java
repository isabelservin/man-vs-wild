package org.tlgcohort.manvswild.GameLogic;

import java.io.*;
import java.util.Scanner;

public class SplashScreen {

    private static Scanner scanner;

    private SplashScreen(){

    }

    // Displays a screen from text file
    public static void displayScreen(String filename) throws IOException{
        scanner = new Scanner(System.in);
        String userInput = " ";
        String fileName = "TextFiles/" + filename;
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
        System.out.println("\n Type NEXT \n");

        while(!userInput.equalsIgnoreCase("next")){
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
