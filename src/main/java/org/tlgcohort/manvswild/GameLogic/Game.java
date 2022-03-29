package org.tlgcohort.manvswild.GameLogic;

import org.tlgcohort.manvswild.InputParser.InputParser;
import org.tlgcohort.manvswild.Commands.CommandEngine;
import org.tlgcohort.manvswild.LocationEngine.LocationEngine;
import org.tlgcohort.manvswild.Things.Item;
import org.tlgcohort.manvswild.Things.LocationPOJO;
import org.tlgcohort.manvswild.Things.Player;

import java.io.IOException;
import java.util.List;

public class Game {

    private static final String BASECAMP_PATH =  "src/main/resources/Basecamp.json";

    private static List<LocationPOJO> worldMap;
    private static Player player;

    private Game(){
    }

    public static void InitGame(String playerName, int health) throws IOException {
        //map json locations into Location objects
        LocationPOJO loc1 = LocationEngine.locationGenerator(BASECAMP_PATH);

        //map inventory items to List of Item objs
        List<Item> parsedItems = LocationEngine.inventoryGenerator(BASECAMP_PATH);

        System.out.println("First Item in inventory:"+ parsedItems.get(0));

        //set location with this list
        loc1.setItems(parsedItems);

        //System.out.println(loc1.getItems());
        for(Item item : loc1.getItems()){
            System.out.println("Item: " + item.getName() + " " + item.getPowerLevel());
        }
        System.out.println(loc1.getEastExit());

//        worldMap = new ArrayList<>();
//
//        worldMap.add(new LocationPOJO("Basecamp", "eerie abandoned camp site with glooming camp fire reaching for its last breathe.", Direction.NOEXIT, 1, Direction.NOEXIT, 3));
//        worldMap.add(new LocationPOJO("Mountains", "", 0, Direction.NOEXIT, Direction.NOEXIT, 2));
//        worldMap.add(new LocationPOJO("Forest", "", 3, Direction.NOEXIT, 1, Direction.NOEXIT));
//        worldMap.add(new LocationPOJO("Caves", "", Direction.NOEXIT, 2, 0, Direction.NOEXIT));

        player = new Player(playerName, health, loc1);

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

    private static String displayMsg(){
        String msg;
        msg =  "+---------------------------------------------------------------------------------------------------------------------------+\n     " +
                "You see a " + player.getCurrLocation().getDesc()
                +  "\n     You are currently at your " + player.getCurrLocation().getName()
                + ". \n+---------------------------------------------------------------------------------------------------------------------------+";
        return msg;
    }
}