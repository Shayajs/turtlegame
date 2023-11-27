package com.characters;

import java.io.IOException;
import java.util.ArrayList;

import com.items.Inventory;
import com.utils.TurtleFunction;

public class NonPlayerCharacter extends Character{

    private String shortDescription;
    private String longDescription;
    private boolean firstTime = true;
    private ArrayList<String> conversation;

    public NonPlayerCharacter(String name, Inventory inventory) throws IOException {
        super(name, inventory);
        this.conversation = TurtleFunction.getConversationNPC(name + "Conv.txt");
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

    public void interact() throws InterruptedException {
        TurtleFunction.printConversation(this.conversation);
    }
}
