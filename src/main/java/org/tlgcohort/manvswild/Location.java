package org.tlgcohort.manvswild;

public class Location {
    private String name;
    private String description;
    private String exit1;
    private String exit1Location;
    private String tools;
    private String exit2;
    private String exit2Location;

    public Location() {
    }

    public Location(String name, String description, String exit1, String exit1Location, String tools, String exit2, String exit2location) {
        this.name = name;
        this.description = description;
        this.exit1 = exit1;
        this.exit1Location = exit1Location;
        this.tools = tools;
        this.exit2 = exit2;
        this.exit2Location = exit2location;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getExit1() {
        return exit1;
    }

    public String getExit1Location() {
        return exit1Location;
    }

    public String getTools() {
        return tools;
    }

    public String getExit2() {
        return exit2;
    }

    public String getExit2location() {
        return exit2Location;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", \ndescription='" + description + '\'' +
                ", \nexit1='" + exit1 + '\'' +
                ", \nexit1Location='" + exit1Location + '\'' +
                ", \ntools='" + tools + '\'';
    }
}
