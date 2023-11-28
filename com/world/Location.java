package com.world;
import java.util.HashMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import com.characters.NonPlayerCharacter;
import com.items.*;
import com.utils.TurtleFunction;

public class Location {
    private String name;
    private String secondComing; //go2
    private ArrayList<String> firstComing; // go1 
    private String description; //desc
    private Map<String, Exit> exits = new HashMap<>();
    private Inventory inventory;
    private boolean firsttime = true;
    private ArrayList<NonPlayerCharacter> npcs;

    /**
     * Create Location with these parameters
     * @param name
     * @param shortDescription
     * @param longDescription
     * @param exits
     * @param inventory
     * @param npcs
     */
    public Location(String name, String shortDescription, String longDescription,  Map<String, Exit> exits, Inventory inventory, ArrayList<NonPlayerCharacter> npcs) {
        this.name = name;
        this.secondComing = shortDescription;
        this.description = longDescription;
        this.exits = exits;
        this.inventory = inventory;
        this.npcs = npcs;
    }

    /**
     * This is the new way to create a Location with files
     * @param name
     * @param directoryPathString
     * @throws IOException
     */
    public Location(String name, String directoryPathString) throws IOException {
        this.name = name;
        this.secondComing = TurtleFunction.getDescriptionFile(directoryPathString + "/" + "go2_" + name + ".txt");
        this.description = TurtleFunction.getDescriptionFile(directoryPathString + "/" + "desc_" + name + ".txt");
        this.firstComing = TurtleFunction.getConversationNPC(directoryPathString + "/" + "go1_" + name + ".txt");
        this.inventory = new Inventory();
        this.npcs = new ArrayList<>();
    }

    /**
     * Add NPC to area
     * @param newCharacter
     */
    public void addNPC(NonPlayerCharacter newCharacter) {
        if(!this.npcs.contains(newCharacter)) {
            npcs.add(newCharacter);
        }
        else {
            System.out.println(newCharacter.getName() + " is already in this place.");
        }
    }

    /**
     * Add Item to Area
     * @param item
     * @throws RawItemNotAllowedException
     */
    public void addItem(Item item) throws RawItemNotAllowedException {
        this.inventory.addItem(item);
    }

    /**
     * Add exit to the location
     * @param exit
     */
    public void addExit(Exit exit) {
        this.exits.put(exit.getName(), exit);
    }

    /**
     * Returns Description of area
     * @return
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Return name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * return NPC
     * @return
     */
    public ArrayList<NonPlayerCharacter> getNPC() {
        return npcs;
    }

    /**
     * Set the first time they meet each other
     */
    public void lookedat(){
        this.firsttime = false;
    }

    /**
     * Returns all the Exits
     * @return
     */
    public Map<String, Exit> getExit() {
        return this.exits;
    }

    /**
     * Pick an Item in the area only if is Wieldable
     * @param objet
     * @return
     */
    public Item take(String objet) {
        return this.inventory.pickItem(objet);
    }

    /**
     * Get a description of an item in the area
     * @param name
     * @return
     */
    public String getDescriptionOfItem(String name) {
        return this.inventory.getDescriptionOf(name);
    }

    /**
     * Returns all items
     * @return
     */
    public Inventory getInventory() {
        return this.inventory;
    }

    /**
     * This is the function to use to print the entrance dialog
     * @throws InterruptedException
     */
    public void goTo() throws InterruptedException {
        if(this.firsttime) {
            TurtleFunction.print(this.firstComing);
            firsttime = false;
        }
        else
        TurtleFunction.print(this.secondComing);
    }

    /**
     * Print Descreption when you look around
     * @throws InterruptedException
     */
    public void look() throws InterruptedException {
        TurtleFunction.print(this.description);
    }
}
