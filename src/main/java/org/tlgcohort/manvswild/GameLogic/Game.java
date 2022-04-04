package org.tlgcohort.manvswild.GameLogic;

import org.tlgcohort.manvswild.Commands.CommandEngine;
import org.tlgcohort.manvswild.InputParser.InputParser;
import org.tlgcohort.manvswild.LocationEngine.LocationEngine;
import org.tlgcohort.manvswild.Things.Food;
import org.tlgcohort.manvswild.Things.Location;
import org.tlgcohort.manvswild.Things.Player;

import java.io.IOException;

public class Game {

    private static Location[] worldMap;
    private static Player player;
    private static final int INITIAL_HEALTH = 50;
    private static final int INITIAL_ATTACK_POWER = 10;

    public static int progressionTracker = 0;


    private Game(){

    }

    public static void InitGame(String playerName) throws IOException {
        worldMap = LocationEngine.locationGenerator();
        player = new Player(playerName, INITIAL_HEALTH, INITIAL_ATTACK_POWER, progressionTracker, worldMap[0]);
        Food apple = new Food("apple", 10);
        player.getBackpack().add(apple);
    }

    public static void StartGame() throws IOException {
        CommandEngine commandEngine = new CommandEngine(player);
        int progressionTracker = 1;

        while (!(progressionTracker == 3 )) {
              player.displayStatAndMsg();
              commandEngine.displayCommands();
              commandEngine.commandProcessor(InputParser.parseInput());

            if ( player.getEventCount() == 10){
                System.out.println("\tYou are tired from today, its time to take a rest....");
                progressionTracker++;
            }
        }
    }

    public static Location[] getWorldMap() {
        return worldMap;
    }
}