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
    //private static List<Location> myMap;

    private Game(){
    }

    public static void InitGame(String playerName, int health) throws IOException {
        worldMap = LocationEngine.locationGenerator(LOCATION_PATH);

        //convert array to list
        //myMap = Arrays.asList(worldMap);

        player = new Player(playerName, health, worldMap[0]);
        System.out.println(Arrays.toString(worldMap));

        //print each location in our map
        int counter = 1;
        for(Location location: worldMap){
            System.out.println(counter + "). " + location);
            counter++;
        }

        Food apple = new Food("apple", 10);
        player.getBackpack().add(apple);
        player.attack();
    }

    public static void StartGame() throws IOException {
        CommandEngine commandEngine = new CommandEngine(player);
        int progressionTracker = 0;

        while (!(progressionTracker == 2)) {
            if (progressionTracker == 0) {
                System.out.println(player.displayPlayerStats());
                System.out.println(displayMsg());

                commandEngine.displayCommands();

                List<String> inputParser = InputParser.parseInput();
                commandEngine.commandProcessor(inputParser);
                if (inputParser.get(0).contains("xyz")) {
                    progressionTracker++;
                }
            }

            if (progressionTracker == 1) {

                System.out.println("\nI made it to the river......Is that a zombie !!!!\n");
                commandEngine.displayCommands();
                List<String> inputParserTwo = InputParser.parseInput();
                commandEngine.commandProcessor(inputParserTwo);
                if (inputParserTwo.get(0).equals("go")) {
                    System.out.println("\nEnd demo");
                    progressionTracker++;
                }
            }
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