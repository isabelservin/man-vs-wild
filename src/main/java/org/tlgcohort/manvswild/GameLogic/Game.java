package org.tlgcohort.manvswild.GameLogic;

import org.tlgcohort.manvswild.Commands.CommandEngine;
import org.tlgcohort.manvswild.InputParser.InputParser;
import org.tlgcohort.manvswild.LocationEngine.LocationEngine;
import org.tlgcohort.manvswild.Things.Food;
import org.tlgcohort.manvswild.Things.Location;
import org.tlgcohort.manvswild.Things.Player;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Game {

    private static final String LOCATION_PATH = "src/main/resources/Locations.json";
    private static Location[] worldMap;
    private static Player player;
    static int progressionTracker = 0;
    //private static List<Location> myMap;

    private Game(){
    }

    public static void InitGame(String playerName, int health) throws IOException {
        worldMap = LocationEngine.locationGenerator(LOCATION_PATH);
        player = new Player(playerName, health,progressionTracker, worldMap[0]);
        Food apple = new Food("apple", 10);
        player.getBackpack().add(apple);
/*
      convert array to list
      myMap = Arrays.asList(worldMap);
       System.out.println(Arrays.toString(worldMap));
       print each location in our map
        int counter = 1;
        for(Location location: worldMap){
            System.out.println(counter + "). " + location);
            counter++;
        }
*/


    }

    public static void StartGame() throws IOException {
        CommandEngine commandEngine = new CommandEngine(player);

        while (!(progressionTracker == 2)) {
            if (player.getCurrLocation().getName().equalsIgnoreCase("basecamp")){
                System.out.println(player.getCurrLocation().getScripts()[0]);
                commandEngine.displayCommands();
                commandEngine.commandProcessor(InputParser.parseInput());
            }
            if (player.getCurrLocation().getName().equalsIgnoreCase("river")){
                System.out.println("You are at the " + player.getCurrLocation().getName());
                System.out.println(player.getCurrLocation().getDesc());
                commandEngine.displayCommands();
                commandEngine.commandProcessor(InputParser.parseInput());
            }
            if (player.getCurrLocation().getName().equalsIgnoreCase("waterfall")){
                System.out.println(player.getCurrLocation().getDesc());
                commandEngine.displayCommands();
                commandEngine.commandProcessor(InputParser.parseInput());
            }
            if (player.getCurrLocation().getName().equalsIgnoreCase("forest")){
                System.out.println(player.getCurrLocation().getDesc());
                System.out.println(player.getCurrLocation().getScripts()[2]);
                System.out.println(player.getCurrLocation().getScripts()[0]);
                commandEngine.displayCommands();
                commandEngine.commandProcessor(InputParser.parseInput());
            }

            if(player.getEventCount() == 10){
                progressionTracker++;
            }
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


    private static String displayMsg(){
        String msg;
        msg =  "+---------------------------------------------------------------------------------------------------------------------------+\n     " +
                "You see a " + player.getCurrLocation().getDesc()
                +  "\n     You are currently at your " + player.getCurrLocation().getName()
                + ". \n+---------------------------------------------------------------------------------------------------------------------------+";
        return msg;
    }
}