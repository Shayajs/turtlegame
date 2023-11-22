package com.characters;

import com.items.Inventory;

public class Hero extends Character{

    private boolean bankKnown = false;

    public Hero(String n, Inventory inventory) {
        super(n, inventory);
        //TODO Auto-generated constructor stub
    }

    public void KnowTheBank(){
        this.bankKnown = true;
    }

}
