package org.tlgcohort.manvswild.Commands;
import org.tlgcohort.manvswild.GameLogic.SaveGame;
import org.tlgcohort.manvswild.Things.Color;
import org.tlgcohort.manvswild.Things.Player;
import java.util.List;
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
        String commandMsg = "\n||======================================||" +
                "\n     Available Commands:" +
                "\n||======================================||";
        System.out.println(commandMsg);
        for (Commands aCommand : commands) {
            System.out.print("[" + Color.RED + aCommand + Color.RESET +"]");
        }
        System.out.println("\n||======================================||");
        System.out.println("+----------------------------------------+");
        System.out.println("    Enter Two Words [VERB] [NOUN]");
    }

    //processes an array of 1 Verb and 1 Noun
    public void commandProcessor(List<String> keywords) {
                //TODO Add try catch block
        switch (keywords.get(0).toLowerCase()) {
            case "look":
                try{lookCommand(keywords.get(1).toLowerCase());}
                catch(Exception e){
                    System.out.println("Try to two words");
                }
                break;
            case "talk":
                try{talkCommand(keywords.get(1).toLowerCase());}
                catch(Exception e){
                System.out.println("Try to two words");
            }
                break;
            case "get":
                try{getCommand(keywords.get(1).toLowerCase());}
                catch(Exception e){
                System.out.println("Try to two words");
            }
                break;
            case "heal": //TODO Must refactor to account for the second user input
                try{player.heal();}
                catch(Exception e){
                System.out.println("Try to two words");
            }
                break;
            case "go":
                try{goCommand(keywords.get(1).toLowerCase());}
                catch(Exception e){
                System.out.println("Try to two words");
            }
                break;
            case "save":
                System.out.println("Saving game...");
                SaveGame saveGame = new SaveGame();
                saveGame.saving(player);
                break;
                //TODO Do we need these commands?
//            case "tools":
//                toolsCommand();
//                break;
//            case "map":
//                mapCommand();
//                break;
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
                    System.out.println("I see nothing");
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
    private void getCommand(String item) {

        switch (item.toLowerCase()) {
            case "itemone":
                System.out.println("Drill into properties of itemONe");
                break;
            case "itemtwo":
                // code block
                break;
            default:
                // code block

        }
    }

    private void goCommand(String userInputLocation) {

        player.move(userInputLocation);
    }

    //TODO Do we still need these ?
   /*
   private void toolsCommand() {
        scanner = new Scanner(System.in);
        int count = 0;
        System.out.println("Tools Available: ");
        for(String aTool : player.getBackpack()){
            System.out.println((count+1)+ ") " +aTool);
            count++;
        }
        System.out.println("\nWhat tool to use? <enter a number?");
        String choice = scanner.nextLine();

        for(String aTool : player.getBackpack())
            if (choice.toLowerCase().equals(aTool)) {
                System.out.println(aTool);
                break;
            }
    }
    private void mapCommand() {
        scanner = new Scanner(System.in);
        int count = 0;
        System.out.println("Location Available: ");
        for(LocationPOJO aLocation : worldMap){
            System.out.println((count+1)+ ") " +aLocation);
            count++;
        }
        System.out.println("\nWhere do you want to go? <enter a number?");
        int choice = scanner.nextInt();
        player.setCurrLocation(worldMap.get(choice-1));
    }

    */

}
