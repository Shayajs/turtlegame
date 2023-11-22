package com.characters;

public class NonPlayerCharacter extends Character{

    private String shortDescription;
    private String longDescription;
    private boolean firstime = true;

    public String getDescription(){
        if (firsttime){
            return longDescription
        }
        else{
            return shortDescription
        }
    }

    public String getLongDescription() {
        return longDescription
    }

    public void lookedat(){
        this.firsttime = false;
    }
}
