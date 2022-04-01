package org.tlgcohort.manvswild.Things;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.tlgcohort.manvswild.GameLogic.Game.getWorldMap;


public class Player implements Serializable {

    private String name;
    private int health = 50;
    private List<Food> backpack = new ArrayList<>();
    private Location currLocation;
    private int power = 5;
    private int progressionTracker = 0;
    private int eventCount = 0;

    public Player(String name, int progressionTracker,Location currLocation) {
        this.name = name;
        this.currLocation = currLocation;
    }

    public Player() {

    }

    public void displayStatAndMsg(){
        System.out.println(displayPlayerStats());
        System.out.println(displayMsg());
    }

    private String displayPlayerStats(){
        String stats;
        stats = "\n||=========================================================================================================================||\n" +
                "     Player: " + getName() + "    Health Lvl: " + getHealth() + "    Location: " + getCurrLocation().getName() + "    Backpack: " + getBackpack() +
                "\n||=========================================================================================================================||";
        return stats;
    }
    private String displayMsg(){
        String msg;
        msg =  "+---------------------------------------------------------------------------------------------------------------------------+\n     " +
                "You see a " + getCurrLocation().getDesc()
                +  "\n     You are currently at your " + getCurrLocation().getName()
                + ". \n+---------------------------------------------------------------------------------------------------------------------------+";
        return msg;
    }

    public void attack(){
        if (currLocation.presentNPC() && health > 0){
            if (currLocation.getNpc().getHealth() > 0){
                System.out.println(currLocation.getNpc().getName() + " health BEFORE damage: " + currLocation.getNpc().getHealth());
                int opponentDamage = currLocation.getNpc().getHealth() - power;
                currLocation.getNpc().setHealth(opponentDamage);

                System.out.println(currLocation.getNpc().getName() + " health AFTER damage: " + currLocation.getNpc().getHealth());

                System.out.println(name + " attacked " + currLocation.getNpc().getName() + "!!");
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

    // iterates through player backpack and user chooses item which then adds to player health
    //TODO add feature to remove from backpack when used....
    public void heal(){
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        System.out.println("\nFood Available : ");

        for(Food aItem : backpack){
            System.out.println((count+1)+ ") " +aItem);
            count++;
        }
        System.out.println("\nEat food? <enter a number?");
        int choice = scanner.nextInt();
        setHealth(health+backpack.get(choice-1).getHealthPoints());
        setEventCount(2);
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

    public int getPower() {
        return power;
    }

    public int getProgressionTracker() {
        return progressionTracker;
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
