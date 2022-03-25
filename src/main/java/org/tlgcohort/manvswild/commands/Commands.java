package org.tlgcohort.manvswild.Commands;

public enum Commands {

    Go("Player goes to a location"),
    Look("Take a look at something"),
    Talk("Talk to something"),
    Heal("Heal yourself"),
    Tools("Check your bag");

    String currentCommand;

    Commands(String command) {
        currentCommand = command;
    }

    String showCommands(){
        return currentCommand;
    }
}