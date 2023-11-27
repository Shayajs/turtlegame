package com.characters;

import com.items.Inventory;
import com.items.Item;
import com.items.RawItemNotAllowedException;

public abstract class Character {
    protected String name;
    protected Inventory inventory;

    public Character(String name, Inventory inventory){
        this.name = name;
        this.inventory = inventory;
    }

    public Character(String name){
        this.name = name;
        this.inventory = new Inventory();
    }

    public String getName() {
        return name;
    }

    public void addItem(Item item) throws RawItemNotAllowedException {
        this.inventory.addItem(item);
    }
}
