package org.tlgcohort.manvswild.commands;

public enum Commands {

    Go("Player goes to a location"),
    Fight("Choose to fight"),
    Run("Flee away from enemy"),
    Look("Take a look at something"),
    Talk("Talk to something");

    String currentCommand;

    Commands(String command) {
        currentCommand = command;
    }

    String showCommands(){
        return currentCommand;
    }
}