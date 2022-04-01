package org.tlgcohort.manvswild.GameLogic;

import org.tlgcohort.manvswild.LocationEngine.LocationEngine;
import org.tlgcohort.manvswild.Things.Location;
import org.tlgcohort.manvswild.Things.Player;

import java.io.*;
import java.util.ArrayList;

public class SaveGame{
    private static final String LOCATION_PATH = "src/main/resources/Locations.json";
    public void saving(Player player){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("savedGame"));
            out.writeObject(player);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
