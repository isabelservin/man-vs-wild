package org.tlgcohort.manvswild.GameLogic;

import org.tlgcohort.manvswild.Things.Player;

import java.io.*;

public class SaveGame{
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
