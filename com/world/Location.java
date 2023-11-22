package com.world;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

/**
 * 
 */
public class Location {
    private String name;
    private String shortDescription;
    private String longDescription;
    private Map<String, Exit> exits = new HashMap<>();
    private Inventory inventory;
    private bool firsttime = true;
    private ArrayList<NonPlayerCharacter> npcs;

    public Location(String n, String sd, String ld,  Map<String, Exit> exits, Inventory inventory, ArrayList<NonPlayerCharacter> npcs) {
        this.name = n;
        this.shortDescriptiondescription = sd;
        this.longDescriptiondescription = ld;
        this.exits = exits;
        this.inventory = inventory;
        this.npcs = npcs;
    }

    public String getDescription(){
        if (firsttime){
            return longDescription
        }
        else{
            return shortDescription
        }
    }

    public String getLongDescription() {
        return longDescription
    }

    public void lookedat(){
        this.firsttime = false;
    }


}
