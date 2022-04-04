package org.tlgcohort.manvswild.Commands;

public enum Commands {

    Go("Player goes to a location"),
    Look("Take a look at something"),
    Attack("Attack your opponent"),
    Talk("Talk to something"),
    Get("Grab a item and put into bag"),
    Eat("Heal yourself"),
    View_Map("View your map"),
    Save("Save the game"),
    Quit_Game("Quit the game");

    String currentCommand;

    Commands(String command) {
        currentCommand = command;
    }

}