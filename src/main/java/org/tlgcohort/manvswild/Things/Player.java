package org.tlgcohort.manvswild.Things;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.tlgcohort.manvswild.GameLogic.Game.getWorldMap;


public class Player implements Serializable {

    private String name;
    private int health;
    private int attackPower;

    private List<Food> backpack = new ArrayList<>();
    private List<Item> toolBackpack = new ArrayList<>();
    private Location currLocation;
    private int progressionTracker = 0;
    private int eventCount = 0;


    public Player(String name, int health, int attackPower, int progressionTracker,Location currLocation) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.progressionTracker = progressionTracker;
        this.currLocation = currLocation;
    }

    public void displayStatAndMsg(){
        System.out.println(displayPlayerStats());
        System.out.println(displayMsg());
    }

    private String displayPlayerStats(){
        String stats;
        stats = "\n||================================================================================================================================================||\n" +
                "\tPlayer: " + getName() + "\t\tHealth Lvl: " + getHealth() + "\t\tLocation: " + getCurrLocation().getName() + "\t\tBackpack: " + getBackpack() + getToolBackpack() +
                "\n||================================================================================================================================================||";
        return stats;
    }
    private String displayMsg(){
        String body;
        body =  "+--------------------------------------------------------------------------------------------------------------------------------------------------+\n" +
                "\t"+ getCurrLocation().getDesc() + "\n\n\t" + getCurrLocation().randomScript()
                + ". \n+--------------------------------------------------------------------------------------------------------------------------------------------------+";
        return body;
    }

    public void attack(){
        calcAttackPower();
        if (currLocation.presentNPC()){
            if (currLocation.getNpc().getHealth() > 0){
                int opponentDamage = currLocation.getNpc().getHealth() - attackPower;
                currLocation.getNpc().setHealth(opponentDamage);
                System.out.println(name + " attacked " + currLocation.getNpc().getName() + "!!\n\t You inflicted " + attackPower + " damage!");
                setEventCount(3);
            } else{
                System.out.println(currLocation.getNpc().getName() + " is already dead. Calm down killer.");
            }
        } else{
            System.out.println("There is nothing to attack, goofy.");
        }
    }

    // takes all exits from current location and compares the user input to find a match, if so , then changes location to user input...
    public void move(String newLocation){
        int newLocationIndex = -1;
        if(currLocation.allExitsGenerator().contains(newLocation)){
            System.out.println("Going to " + newLocation);
        for (int i = 0; i < getWorldMap().length; i++){
            if (getWorldMap()[i].getName().toLowerCase().equals(newLocation)){
                newLocationIndex = i;
                break;
            }
            }
        setCurrLocation(getWorldMap()[newLocationIndex]);
        setEventCount(3);
        }
        else{
            System.out.println("\nYou cannot go there.....\n");
        }
    }

    // allows player to select an item from their backpack to use and increase their health
    public void heal(){
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        System.out.println("\nFood Available : ");

        for(Food aItem : backpack){
            System.out.println((count+1)+ ") " + aItem);
            count++;
        }
        System.out.println("\nEat food? <enter a number?");
        int choice = scanner.nextInt();
        setHealth(health + backpack.get(choice-1).getHealthPoints());
        backpack.remove(choice - 1);
        setEventCount(2);
    }

    //grab an item from the currentLocation
    public void get(String item) {
        try {
            int newLocationIndex = -1;
            for (int i = 0; i < currLocation.getItems().size(); i++) {
                if (currLocation.getItems().get(i).getName().toLowerCase().equals(item)) {
                    newLocationIndex = i;
                    break;
                }
            }
            toolBackpack.add(currLocation.getItems().get(newLocationIndex));
            setEventCount(1);
        } catch (Exception e) {
            System.out.println("\nYou cannot get that....\n");
        }
    }

    //display players current location on the map
    public String viewPortableMap(){
        return this.getCurrLocation().getMap();
    }

    //calculate and increasee the attack power of the player based on the items they have
    private void calcAttackPower(){
        int power = 0;
        for(Item item : toolBackpack){
            power += item.getPowerLevel();
        }
        int attackDamage = (power + attackPower) / 2;
        setAttackPower(attackDamage);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public List<Food> getBackpack() {
        return backpack;
    }

    public void setBackpack(List<Food> backpack) {
        this.backpack = backpack;
    }

    public Location getCurrLocation() {
        return currLocation;
    }

    public void setCurrLocation(Location currLocation) {
        this.currLocation = currLocation;
    }

    public int getEventCount() {
        return eventCount;
    }

    public void setEventCount(int eventCount) {
        this.eventCount = eventCount;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int setAttackPower(int attackPower){
        return this.attackPower = attackPower;
    }

    public int getProgressionTracker() {
        return progressionTracker;
    }

    public List<Item> getToolBackpack() {
        return toolBackpack;
    }

    public void setToolBackpack(List<Item> toolBackpack) {
        this.toolBackpack = toolBackpack;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", backpack=" + backpack +
                ", currLocation=" + currLocation +
                '}';
    }
}
