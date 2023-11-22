package com.characters;

import com.items.Inventory;

public class NonPlayerCharacter extends Character{

    private String shortDescription;
    private String longDescription;
    private boolean firstTime = true;

    public NonPlayerCharacter(String n, Inventory inventory) {
        super(n, inventory);
    }

    public String getDescription(){
        if (this.firstTime){
            return longDescription;
        }
        else{
            return shortDescription;
        }
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void lookedat(){
        this.firstTime = false;
    }
}
