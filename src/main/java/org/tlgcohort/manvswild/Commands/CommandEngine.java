package org.tlgcohort.manvswild.Commands;
import org.tlgcohort.manvswild.Thing.LocationPOJO;
import org.tlgcohort.manvswild.Thing.Player;
import java.util.List;
import java.util.Scanner;

public class CommandEngine {

    //Fields
    private Commands[] commands = Commands.values();
    private Player player;
    private List<LocationPOJO> worldMap;
    private Scanner scanner;

    //Constructor
    public CommandEngine(Player player, List<LocationPOJO> worldMap) {
        this.player = player;
        this.worldMap = worldMap;
    }

    //Business Methods
    public void displayCommands() {
        System.out.println("\nAvailable Commands:");
        for (Commands aCommand : commands) {
            System.out.println(aCommand);
        }
        System.out.println("\n Enter Two Words [NOUN] [VERB]");
    }



    //processes an array of 1 Verb and 1 Noun
    public void commandProcessor(List<String> keywords) {

        switch (keywords.get(0).toLowerCase()) {
            case "look":
                lookCommand(keywords.get(1).toLowerCase());
                break;
            case "talk":
                talkCommand(keywords.get(1).toLowerCase());
                break;
            case "get":
                getCommand(keywords.get(1).toLowerCase());
                break;
            case "heal":
                healCommand(keywords.get(1).toLowerCase());
                break;
            case "go":
                goCommand(keywords.get(1).toLowerCase());
                break;
            case "tools":
                toolsCommand();
                break;
            case "map":
                mapCommand();
                break;
            default:
                break;
        }

    }

    // commands based on VERB, then process the NOUN
    private void lookCommand(String item) {

        switch (item.toLowerCase()) {
            case "can":
                System.out.println("Beans, Beans and Beans");
                break;
            case "north":
                System.out.println("I can see a river ahead....");
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
    private void healCommand(String character) {

        switch (character.toLowerCase()) {
            case "characterone":
                System.out.println("Drill into properties of character");
                break;
            case "itemtwo":
                // code block
                break;
            default:
                // code block

        }
    }
    private void goCommand(String location) {

        switch (location.toLowerCase()) {
            case "campsite":
                System.out.println("Drill into properties of location");
                break;
            case "itemtwo":
                // code block
                break;
            default:
                // code block

        }
    }
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

}
