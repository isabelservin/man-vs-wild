package org.tlgcohort.manvswild.Commands;

public enum Commands {

    Go("Player goes to a location"),
    Look("Take a look at something"),
    Attack("Attack your opponent"),
    Talk("Talk to something"),
    Get("Grab a item and put into bag"),
    Eat("Heal yourself"),
    Backpack("Check your bag"),
    View("View your map"),
    Save("Save the game"),
    Quit("Quit the game");

    String currentCommand;

    Commands(String command) {
        currentCommand = command;
    }

}