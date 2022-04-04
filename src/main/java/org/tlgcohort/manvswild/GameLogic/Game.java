package org.tlgcohort.manvswild.GameLogic;

import org.tlgcohort.manvswild.Commands.CommandEngine;
import org.tlgcohort.manvswild.InputParser.InputParser;
import org.tlgcohort.manvswild.LocationEngine.LocationEngine;
import org.tlgcohort.manvswild.Things.Food;
import org.tlgcohort.manvswild.Things.Location;
import org.tlgcohort.manvswild.Things.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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


//            if (player.getCurrLocation().getName().equalsIgnoreCase("basecamp")){
////                player.displayStatAndMsg();
////
////                commandEngine.displayCommands();
////                commandEngine.commandProcessor(InputParser.parseInput());
//            }
//            else if (player.getCurrLocation().getName().equalsIgnoreCase("river")){
//                player.displayStatAndMsg();
//                System.out.println(player.getCurrLocation().getDesc());
//                commandEngine.displayCommands();
//                commandEngine.commandProcessor(InputParser.parseInput());
//            }
//            else if (player.getCurrLocation().getName().equalsIgnoreCase("waterfall")){
//                player.displayStatAndMsg();;
//                System.out.println(player.getCurrLocation().getDesc());
//                commandEngine.displayCommands();
//                commandEngine.commandProcessor(InputParser.parseInput());
//            }
//            else if (player.getCurrLocation().getName().equalsIgnoreCase("forest")){
//                player.displayStatAndMsg();
//                System.out.println(player.getCurrLocation().getScripts()[2]);
//                System.out.println(player.getCurrLocation().getScripts()[0]);
//                System.out.println(player.getCurrLocation().getScripts()[1]);
//                commandEngine.displayCommands();
//
//                commandEngine.commandProcessor(InputParser.parseInput());
//            }
//            else if (player.getCurrLocation().getName().equalsIgnoreCase("mountains")){
//                player.displayStatAndMsg();
//                System.out.println(player.getCurrLocation().getScripts()[0]);
//                System.out.println(player.getCurrLocation().getScripts()[1]);
//                commandEngine.displayCommands();
////                commandEngine.commandProcessor(InputParser.parseInput());
//            }
//             if(player.getEventCount() == 10){
//                progressionTracker++;
//            }
//            if (progressionTracker == 0) {
//                System.out.println(player.displayPlayerStats());
//                System.out.println(displayMsg());
//
//                commandEngine.displayCommands();
//
//                List<String> inputParser = InputParser.parseInput();
//                commandEngine.commandProcessor(inputParser);
//                if (inputParser.get(0).contains("xyz")) {
//                    progressionTracker++;
//                }
//            }

        }
    }

    public static Location[] getWorldMap() {
        return worldMap;
    }
}