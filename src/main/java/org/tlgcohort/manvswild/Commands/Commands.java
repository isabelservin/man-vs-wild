package org.tlgcohort.manvswild.Commands;

public enum Commands {

    Go("Player goes to a location"),
    Look("Take a look at something"),
    Talk("Talk to something"),
    Get("Grab a item and put into bag"),
    Eat("Heal yourself"),
    Backpack("Check your bag"),
    Save("Save the game");

    String currentCommand;

    Commands(String command) {
        currentCommand = command;
    }

    String showCommands(){
        return currentCommand;
    }
}