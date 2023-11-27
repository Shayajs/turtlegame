package com.world;
import java.util.HashMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import com.characters.NonPlayerCharacter;
import com.items.*;
import com.utils.TurtleFunction;
/**
 * 
 */
public class Location {
    private String name;
    private String secondComing; //go2
    private ArrayList<String> firstComing; // go1 
    private String description; //desc
    private Map<String, Exit> exits = new HashMap<>();
    private Inventory inventory;
    private boolean firsttime = true;
    private ArrayList<NonPlayerCharacter> npcs;

    public Location(String name, String shortDescription, String longDescription,  Map<String, Exit> exits, Inventory inventory, ArrayList<NonPlayerCharacter> npcs) {
        this.name = name;
        this.secondComing = shortDescription;
        this.description = longDescription;
        this.exits = exits;
        this.inventory = inventory;
        this.npcs = npcs;
    }

    public Location(String name, String directoryPathString) throws IOException {
        this.name = name;
        this.secondComing = TurtleFunction.getDescriptionFile(directoryPathString + "/" + "go2_" + name + ".txt");
        this.description = TurtleFunction.getDescriptionFile(directoryPathString + "/" + "desc_" + name + ".txt");
        this.firstComing = TurtleFunction.getConversationNPC(directoryPathString + "/" + "go1_" + name + ".txt");
        this.inventory = new Inventory();
        this.npcs = new ArrayList<>();
    }

    public void addNPC(NonPlayerCharacter newCharacter) {
        if(!this.npcs.contains(newCharacter)) {
            npcs.add(newCharacter);
        }
        else {
            System.out.println(newCharacter.getName() + " is already in this place.");
        }
    }

    public void addItem(Item item) throws RawItemNotAllowedException {
        this.inventory.addItem(item);
    }

    public void addExit(Exit exit) {
        this.exits.put(exit.getName(), exit);
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return name;
    }

    public ArrayList<NonPlayerCharacter> getNPC() {
        return npcs;
    }

    public void lookedat(){
        this.firsttime = false;
    }

    public Map<String, Exit> getExit() {
        return this.exits;
    }

    public Item take(String objet) {
        return this.inventory.pickItem(objet);
    }

    public String getDescriptionOfItem(String name) {
        return this.inventory.getDescriptionOf(name);
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void goTo() throws InterruptedException {
        if(this.firsttime) {
            TurtleFunction.print(this.firstComing);
            firsttime = false;
        }
        else
        TurtleFunction.print(this.secondComing);
    }

    public void look() throws InterruptedException {
        TurtleFunction.print(this.description);
    }
}
