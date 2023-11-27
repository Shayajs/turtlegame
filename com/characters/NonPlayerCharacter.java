package com.characters;

import java.io.IOException;
import java.util.ArrayList;

import com.items.Inventory;
import com.utils.TurtleFunction;

public class NonPlayerCharacter extends Character{

    private String shortDescription;
    private String longDescription;
    private boolean firstTime = true;

    private ArrayList<String> attack1 = null;
    private ArrayList<String> attack2 = null;
    private ArrayList<String> look1;
    private ArrayList<String> look2;
    private ArrayList<String> talk1;
    private ArrayList<String> talk2;

    public NonPlayerCharacter(String name, Inventory inventory) throws IOException {
        super(name, inventory);
    }

    public NonPlayerCharacter(String name) throws IOException {
        super(name, new Inventory());
    }

    public void setConversationPath(String look1, String look2, String talk1, String talk2, String attack1, String attack2) throws IOException {
        this.look1 = TurtleFunction.getConversationNPC(look1);
        this.talk1 = TurtleFunction.getConversationNPC(talk1);
        this.attack1 = TurtleFunction.getConversationNPC(attack1);
        this.attack2 = TurtleFunction.getConversationNPC(attack2);
        this.look2 = TurtleFunction.getConversationNPC(look2);
        this.talk2 = TurtleFunction.getConversationNPC(talk2);
    }
    public void setConversationPath(String look1, String look2, String talk1, String talk2) throws IOException {
        this.look1 = TurtleFunction.getConversationNPC(look1);
        this.talk1 = TurtleFunction.getConversationNPC(talk1);
        this.look2 = TurtleFunction.getConversationNPC(look2);
        this.talk2 = TurtleFunction.getConversationNPC(talk2);
    }

    public void setNewTalkPath(String talk3) throws IOException {
        this.talk2 = TurtleFunction.getConversationNPC(talk3);
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

    public void attack() throws InterruptedException{
        if(firstTime) {
            TurtleFunction.print(this.attack1);
            lookedat();
        }
        else
        TurtleFunction.print(this.attack2);
    }

    public void look() throws InterruptedException {
        if(firstTime) {
            TurtleFunction.print(this.look1);
            lookedat();
        }
        else
        TurtleFunction.print(this.look2);
    }

    public void interact() throws InterruptedException {
        if(firstTime) {
            TurtleFunction.print(this.talk1);
            lookedat();
        }
        else
        TurtleFunction.print(this.talk2);
    }
}
