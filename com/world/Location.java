package com.world;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

import com.characters.NonPlayerCharacter;
import com.items.Inventory;
/**
 * 
 */
public class Location {
    private String name;
    private String shortDescription;
    private String longDescription;
    private Map<String, Exit> exits = new HashMap<>();
    private Inventory inventory;
    private boolean firsttime = true;
    private ArrayList<NonPlayerCharacter> npcs;

    public Location(String n, String sd, String ld,  Map<String, Exit> exits, Inventory inventory, ArrayList<NonPlayerCharacter> npcs) {
        this.name = n;
        this.shortDescription = sd;
        this.longDescription = ld;
        this.exits = exits;
        this.inventory = inventory;
        this.npcs = npcs;
    }

    public String getDescription(){
        if (firsttime){
            return this.longDescription;
        }
        else{
            return this.shortDescription;
        }
    }

    public String getLongDescription() {
        return this.longDescription;
    }

    public String getName() {
        return name;
    }

    public void lookedat(){
        this.firsttime = false;
    }


}
