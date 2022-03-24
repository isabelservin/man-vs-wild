package org.tlgcohort.manvswild.commands;

public class CommandEngine {

    //Fields
    private Commands[] commands = Commands.values();

    //Constructor
    public CommandEngine() {
    }

    //Business Methods
    public void displayCommands() {
        System.out.println("\nAvailable Commands:");
        for (Commands aCommand : commands) {
            System.out.println(aCommand);
        }
    }

    //processes an array of 1 Verb and 1 Noun
    public void commandProcessor(String[] keywords) {

        switch (keywords[0].toLowerCase()) {
            case "look":
                lookCommand(keywords[1].toLowerCase());
                break;
            case "talk":
                talkCommand(keywords[1].toLowerCase());
                break;
            default:
                // code block
        }


    }

    private void lookCommand(String item) {

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
}
