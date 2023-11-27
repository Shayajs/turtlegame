package com.characters;

import com.items.Inventory;

public abstract class Character {
    protected String name;
    protected Inventory inventory;

    public Character(String name, Inventory inventory){
        this.name = name;
        this.inventory = inventory;
    }
    public String getName() {
        return name;
    }
}
