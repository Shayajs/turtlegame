package com.characters;

import com.items.Inventory;

public class Hero extends Character{

    private boolean bankKnown;

    /**
     * Set the hero of the game
     * @param name
     * @param inventory
     */
    public Hero(String name, Inventory inventory) {
        super(name, inventory);
        this.bankKnown = false;
    }

    public void setKnowTheBank(){
        this.bankKnown = true;
    }

    public boolean isKnowTheBank() {
        return bankKnown;
    }

}
