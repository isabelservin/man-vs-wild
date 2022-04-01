package org.tlgcohort.manvswild.GameLogic;
import org.tlgcohort.manvswild.Commands.CommandEngine;
import org.tlgcohort.manvswild.InputParser.InputParser;
import org.tlgcohort.manvswild.Things.Player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import static org.tlgcohort.manvswild.GameLogic.Game.progressionTracker;

public class LoadGame {
    public static void loading() {
        Player player = null;
        try {
            FileInputStream fis = new FileInputStream("savedGame");
            ObjectInputStream ois = new ObjectInputStream(fis);
            player = (Player) ois.readObject();
            ois.close();
            System.out.println("Here is where you left off: ");
            System.out.println("Location: " + player.getCurrLocation().getName());
            System.out.println("Health: " + player.getHealth());
            System.out.println("Backpack: " + player.getBackpack());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        CommandEngine commandEngine = new CommandEngine(player);

        while (!(progressionTracker == 2)) {
            if (player.getCurrLocation().getName().equalsIgnoreCase("basecamp")) {
                System.out.println(player.getCurrLocation().getScripts()[0]);
                commandEngine.displayCommands();
                commandEngine.commandProcessor(InputParser.parseInput());
            }
            if (player.getCurrLocation().getName().equalsIgnoreCase("river")) {
                System.out.println(player.getCurrLocation().getDesc());
                commandEngine.displayCommands();
                commandEngine.commandProcessor(InputParser.parseInput());
            }
            if (player.getCurrLocation().getName().equalsIgnoreCase("waterfall")) {
                System.out.println(player.getCurrLocation().getDesc());
                commandEngine.displayCommands();
                commandEngine.commandProcessor(InputParser.parseInput());
            }
            if (player.getCurrLocation().getName().equalsIgnoreCase("forest")) {
                System.out.println(player.getCurrLocation().getDesc());
                System.out.println(player.getCurrLocation().getScripts()[2]);
                System.out.println(player.getCurrLocation().getScripts()[0]);
                commandEngine.displayCommands();
                commandEngine.commandProcessor(InputParser.parseInput());
            }

            if (player.getEventCount() == 10) {
                progressionTracker++;
            }
        }
    }
}
