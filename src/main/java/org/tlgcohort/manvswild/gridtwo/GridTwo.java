package org.tlgcohort.manvswild.GridTwo;

public class GridTwo {
    private String tools,animal,food;
    private int animalHealth;

    public GridTwo() {
    }

    public GridTwo(String tools, String animal, String food,int animalHealth) {
        this.tools = tools;
        this.animal = animal;
        this.food = food;
        this.animalHealth = animalHealth;
    }

    public String getTools() {
        return tools;
    }

    public String getAnimal() {
        return animal;
    }

    public String getFood() {
        return food;
    }

    public int getAnimalHealth() {
        return animalHealth;
    }
}