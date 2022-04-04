package org.tlgcohort.manvswild.Commands;
import com.fasterxml.jackson.core.JsonToken;
import org.tlgcohort.manvswild.GameLogic.SaveGame;
import org.tlgcohort.manvswild.InputParser.Keywords;
import org.tlgcohort.manvswild.Things.Color;
import org.tlgcohort.manvswild.Things.Player;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class CommandEngine {

    //Fields
    private final Commands[] commands = Commands.values();
    private final Player player;

    //Constructor
    public CommandEngine(Player player) {
        this.player = player;
    }

    //Business Methods
    public void displayCommands() {
        String header = "\n||================================================================================================================================================||\n" +
                "\n\tAvailable Commands:" +
                "\n||================================================================================================================================================||\n";
        System.out.println(header);
        for (Commands aCommand : commands) {
            System.out.print("\t[" + aCommand + "]");
        }
        String footer = "\n||================================================================================================================================================||\n" +
                "\n+--------------------------------------------------------------------------------------------------------------------------------------------------+\n" +
                "\n\tEnter Two Words [VERB] [NOUN]";
        System.out.println(footer);
    }

    //processes an array of 1 Verb and 1 Noun
    public void commandProcessor(List<String> keywords) {
                //TODO Add try catch block
        switch (keywords.get(0).toLowerCase()) {

            case "look":
                try{
                    lookCommand(keywords.get(1).toLowerCase());
                } catch(Exception e){
                    System.out.println("Try two words");
                }
                break;

            case "talk":
                try{
                    talkCommand(keywords.get(1).toLowerCase());
                } catch(Exception e){
                System.out.println("Try two words");
            }
                break;

            case "get":
                try{
                    player.get(keywords.get(1).toLowerCase());
                }
//                    getCommand(keywords.get(1).toLowerCase());}
                catch(Exception e){
                System.out.println("Try two words");
            }
                break;

            case "heal": //TODO Must refactor to account for the second user input
                try{
                    player.heal();
                } catch(Exception e){
                System.out.println("Try two words");
            }
                break;

            case "go":
                try{
                    goCommand(keywords.get(1).toLowerCase());
                } catch(Exception e){
                System.out.println("Try two words");
            }
                break;

            case "view":
                try{
                    viewCommand(keywords.get(1).toLowerCase());
                } catch(Exception e){
                    System.out.println("Try two words");
                }
                break;

            case "attack":
                try{
                    player.attack();
                } catch(Exception e){
                    System.out.println("Try two words");
                }
                break;

            case "quit":
                try{
                    quitCommand(keywords.get(1).toLowerCase());

                }catch (Exception e){
                    System.out.println("Try valid commands.");
                }
                break;


            case "save":
                System.out.println("Saving game...");
                SaveGame saveGame = new SaveGame();
                saveGame.saving(player);
                break;

            default:
                System.out.println("Try two words");
                break;
        }
    }

    // commands based on VERB, then process the NOUN
    private void lookCommand(String item) {

        switch (item.toLowerCase()) {
            case "north":
                if(player.getCurrLocation().getNorthExit().isEmpty()){
                    System.out.println("You see nothing");
                }
                else{
                    System.out.println("North Exit: " + player.getCurrLocation().getNorthExit());
                }
                break;

            case "south":
                if(player.getCurrLocation().getSouthExit().isEmpty()){
                    System.out.println("I see nothing");
                }
                else{
                    System.out.println("South Exit: " + player.getCurrLocation().getSouthExit());
                }
                break;

            case "east":
                if(player.getCurrLocation().getEastExit().isEmpty()){
                    System.out.println("I see nothing");
                }
                else{
                    System.out.println("East Exit: " + player.getCurrLocation().getEastExit());
                }
                break;

            case "west":
                if(player.getCurrLocation().getWestExit().isEmpty()){
                    System.out.println("I see nothing");
                }
                else{
                    System.out.println("West Exit: " + player.getCurrLocation().getWestExit());
                }

                break;
            default:
                // code block
        }
    }
    private void talkCommand(String npc) {

        switch (npc) {
            case "npcOne":
                System.out.println("Drill into properties of npc");
                break;
            case "npcTwo":
                // code block
                break;
            default:
                // code block

        }
    }

//    private void getCommand(String item) {
//
//        switch (item.toLowerCase()) {
//            case "itemone":
//                System.out.println("Drill into properties of itemONe");
//                break;
//            case "itemtwo":
//                // code block
//                break;
//            default:
//                // code block
//
//        }
//    }

    private void goCommand(String userInputLocation) {
        player.move(userInputLocation);
    }

    private void viewCommand(String userInput){
        if (userInput.equalsIgnoreCase("map")){
            System.out.println(player.viewPortableMap());
        }
    }

    private void quitCommand(String userInput){
        if(userInput.equalsIgnoreCase("game")){
        System.out.println("Quitting Game....");
        System.exit(0);
        } else{
            System.out.println("Requires 2 word command.");
        }
    }
}
