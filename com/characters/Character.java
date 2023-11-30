package com.characters;

import com.items.Inventory;
import com.items.Item;
import com.items.RawItemNotAllowedException;

public abstract class Character {
    protected String name;
    protected Inventory inventory;

    /**
     * A creation of a new character 
     * @param name
     * @param inventory
     */
    public Character(String name, Inventory inventory){
        this.name = name;
        this.inventory = inventory;
    }

    /**
     * A creation of a new character 
     * @param name
     */
    public Character(String name){
        this.name = name;
        this.inventory = new Inventory();
    }

    /**
     * Get the name of the Character
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Add an item in character's inventory 
     * @param item
     * @throws RawItemNotAllowedException
     */
    public void addItem(Item item) throws RawItemNotAllowedException {
        this.inventory.addItem(item);
    }

    /**
     * Return character's inventory
     * @return
     */
    public Inventory getInventory() {
        return this.inventory;
    }
}
