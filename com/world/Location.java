package com.world;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

import com.characters.NonPlayerCharacter;
import com.items.*;
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

    public Location(String name, String shortDescription, String longDescription,  Map<String, Exit> exits, Inventory inventory, ArrayList<NonPlayerCharacter> npcs) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.exits = exits;
        this.inventory = inventory;
        this.npcs = npcs;
    }

    public void addNPC(NonPlayerCharacter newCharacter) {
        if(!this.npcs.contains(newCharacter)) {
            npcs.add(newCharacter);
        }
        else {

        }
    }
    
    public void addItems(Item item) throws RawItemNotAllowedException {
        this.inventory.addItem(item);
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

    public Map<String, Exit> getExit() {
        return this.exits;
    }


}
