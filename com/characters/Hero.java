package com.characters;

import com.items.Inventory;

public class Hero extends Character{
    /**
     * Set the hero of the game
     * @param name
     * @param inventory
     */
    public Hero(String name, Inventory inventory) {
        super(name, inventory);
    }
}
