package org.tlgcohort.manvswild.GameLogic;

import org.tlgcohort.manvswild.Engine.LocationEngine;
import org.tlgcohort.manvswild.InputParser.InputParser;
import org.tlgcohort.manvswild.Commands.CommandEngine;
import org.tlgcohort.manvswild.Things.Inventory;
import org.tlgcohort.manvswild.Things.LocationPOJO;
import org.tlgcohort.manvswild.Things.Player;

import java.io.IOException;
import java.util.List;

public class Game {

    private final String LOCATION_PATH =  "src/main/resources/Basecamp.json";

    private List<LocationPOJO> worldMap;
    private Player player;

    public Game(String playerName, int health) throws IOException {
        InitGame(playerName, health);
        startGame();
    }

    public void InitGame(String playerName, int health) throws IOException {
        LocationEngine locationEngine = new LocationEngine();
        LocationPOJO loc1 = locationEngine.locationGenerator(LOCATION_PATH);
        List<Inventory> gridOneLocation = locationEngine.inventoryGenerator(LOCATION_PATH);
        Inventory i = new Inventory();
        System.out.println(gridOneLocation.get(0).getPowerLevel());
        loc1.setItems(gridOneLocation);
        //System.out.println(loc1.getItems());
        for(Inventory item : loc1.getItems()){
            System.out.println(item.getName() + " " + item.getPowerLevel());
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

    public void startGame() throws IOException {

        CommandEngine commandEngine = new CommandEngine(player, worldMap);
        int progressionTracker = 0;

        while (!(progressionTracker == 2)) {
            if (progressionTracker == 0) {
                System.out.println(player.displayPlayerStats());
                System.out.println(displayMsg());

                System.out.println("\nYou wake up and realize you are in a tent with no idea how you got there,\n" +
                        "and now you hear the sounds of river, only to come out and realize you are in a Jungle!");
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



        //conditional statement.....


//        command = userInput.nextLine();
//        //System.out.println("\n*User enters keyword to get information on their location*");
//        //TO-DO: user enters keyword to get information on location
//        System.out.println("Here is some information on your location\n");
//        System.out.println(gridOneLocation.get(0));
//
//        System.out.println("\n*User enters keyword to grab tool*");
//        //TO-DO: user enters keyword to pick up firewood
//        System.out.println("You picked up " + access.getTools());
//
//        //if user input == go EAST
//        //TO-DO user enters keyword to go EAST to the river
//        GridTwoEngine gridTwo = new GridTwoEngine();    //loading gridTwo object
//        GridTwo gridTwoAccess = gridTwo.gridTwoEngine();
//        System.out.println("\n*User enters to go east*");
//        System.out.println("This is a really strong current, and so loud I can barely hear anything around me");
//        System.out.println("There is a " + gridTwoAccess.getAnimal()+ "!");
//
//        //TO-DO user enters keyword to attack the animal
//        System.out.println("\n*User enters to attack the animal*");
//        System.out.println("The " + gridTwoAccess.getAnimal() + "'s" + " health is " + gridTwoAccess.getAnimalHealth());

    }

    private String displayMsg(){
        String msg;
        msg =  "+---------------------------------------------------------------------------------------------------------------------------+\n     " +
                "You see a " + player.getCurrLocation().getDesc()
                +  "\n     You are currently at your " + player.getCurrLocation().getName()
                + ". \n+---------------------------------------------------------------------------------------------------------------------------+";
        return msg;
    }
}