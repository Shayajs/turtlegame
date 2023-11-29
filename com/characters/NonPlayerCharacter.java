package com.characters;

import java.io.IOException;
import java.util.ArrayList;

import com.items.Inventory;
import com.utils.MiniGame;
import com.utils.TurtleFunction;
import com.world.Exit;

public class NonPlayerCharacter extends Character{

    private static NonPlayerCharacter boss;

    private MiniGame minigame = null;

    private String shortDescription;
    private String longDescription;
    private boolean firstTime = true;
    private boolean firstTimeAttack = true;

    private ArrayList<String> attack1 = null;
    private ArrayList<String> attack2 = null;
    private ArrayList<String> look1;
    private ArrayList<String> look2;
    private ArrayList<String> talk1;
    private ArrayList<String> talk2;

    private Exit exitToUnlockTalking = null;

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

    public void attack() throws InterruptedException, IOException{
        if(this.minigame != null)
        minigame.play();

        if(firstTimeAttack && attack1 != null) {
            TurtleFunction.print(this.attack1);
            firstTimeAttack = false;
        }
        else if(!firstTimeAttack && attack2 != null)
        TurtleFunction.print(this.attack2);
        else TurtleFunction.print("You can not attack " + this.name);
    }

    public void look() throws InterruptedException {
        if(firstTime) {
            TurtleFunction.print(this.look1);
            lookedat();
        }
        else
        TurtleFunction.print(this.look2);
    }

    public void setExitUnlockable(Exit e) {
        exitToUnlockTalking = e;
    }

    public void interact() throws InterruptedException {
        if(firstTime) {
            TurtleFunction.print(this.talk1);
            lookedat();
        }
        else
        TurtleFunction.print(this.talk2);

        if(exitToUnlockTalking != null) {
            if(exitToUnlockTalking.isLocked()) {
                exitToUnlockTalking.unlock();
                TurtleFunction.print("You unlock " + exitToUnlockTalking.getDestination().getName() + " location.");
            }
        }
    }

    public static void setBoss(NonPlayerCharacter bossCarac, ArrayList<NonPlayerCharacter> forestMobs) throws IOException {
        boss = bossCarac;
        boss.minigame = new MiniGame(
            "res\\text\\OldBank\\question1_monkey.txt",
            "res\\text\\OldBank\\question2_monkey.txt",
            "res\\text\\OldBank\\question3_monkey.txt",
            "res\\text\\OldBank\\talk_true1.txt",
            "res\\text\\OldBank\\talk_true2.txt",
            "res\\text\\OldBank\\talk_true3.txt",
            "res\\text\\OldBank\\talk_true.txt",
            "res\\text\\OldBank\\talk_false.txt",
            forestMobs
        );
    } 
}
