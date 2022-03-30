package org.tlgcohort.manvswild.GameLogic;

import org.tlgcohort.manvswild.InputParser.InputParser;
import org.tlgcohort.manvswild.Commands.CommandEngine;
import org.tlgcohort.manvswild.LocationEngine.LocationEngine;
import org.tlgcohort.manvswild.Things.LocationPOJO;
import org.tlgcohort.manvswild.Things.Player;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Game {

    private static final String LOCATION_PATH = "src/main/resources/Locations.json";
    private static List<LocationPOJO> worldMap;
    private static Player player;

    private Game(){
    }

    public static void InitGame(String playerName, int health) throws IOException {
        //reads json and maps it to an array or Location objs
        LocationPOJO[] locations = LocationEngine.locationGenerator(LOCATION_PATH);

        //convert array to list
        worldMap = Arrays.asList(locations);

        //print each location in our map
        int counter = 1;
        for(LocationPOJO location: worldMap){
            System.out.println(counter + "). " + location);
            counter++;
        }

        player = new Player(playerName, health, worldMap.get(1));
//        player.attack();
//        player.attack();
//        player.attack();
//        player.attack();
//        player.attack();

    }

    public static void StartGame() throws IOException {

        CommandEngine commandEngine = new CommandEngine(player, worldMap);
        int progressionTracker = 0;

        while (!(progressionTracker == 2)) {
            if (progressionTracker == 0) {
                System.out.println(player.displayPlayerStats());
                System.out.println(displayMsg());

                commandEngine.displayCommands();

                List<String> inputParser = InputParser.parseInput();
                commandEngine.commandProcessor(inputParser);
                if (inputParser.get(0).contains("go")) {
                    progressionTracker++;
                }
            }

            if (progressionTracker == 1) {

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

    private static String displayMsg(){
        String msg;
        msg =  "+---------------------------------------------------------------------------------------------------------------------------+\n     " +
                "You see a " + player.getCurrLocation().getDesc()
                +  "\n     You are currently at the " + player.getCurrLocation().getName()
                + ". \n+---------------------------------------------------------------------------------------------------------------------------+";
        return msg;
    }
}