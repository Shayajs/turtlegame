package com.characters;

import java.io.IOException;
import java.util.ArrayList;

import com.items.Inventory;
import com.utils.MiniGame;
import com.utils.TurtleFunction;
import com.world.Exit;

public class NonPlayerCharacter extends Character{

    // For the mini game
    private static NonPlayerCharacter boss;

    // For the monkey
    private MiniGame minigame = null;

    // This is the first variable of a NPC
    private String shortDescription;
    private String longDescription;
    private boolean firstTime = true;
    private boolean firstTimeAttack = true;

    /**
     * A NPC have 3 situation :
     * If you attack him
     * If you look him
     * If you talk to him
     * 
     * But also a other situation if you talk, attack or tolk to him a second time.
     * Attack is facultative
     */
    private ArrayList<String> attack1 = null;
    private ArrayList<String> attack2 = null;
    private ArrayList<String> look1;
    private ArrayList<String> look2;
    private ArrayList<String> talk1;
    private ArrayList<String> talk2;

    // In Talk with this NPC, you can unlock location, or not if this rest in null stat.
    private Exit exitToUnlockTalking = null;

    /**
     * A Non Player Character (NPC) is set here
     * @param name
     * @param inventory
     * @throws IOException
     */
    public NonPlayerCharacter(String name, Inventory inventory) throws IOException {
        super(name, inventory);
    }

    /**
     * A NPC is set here.
     * @param name
     * @throws IOException
     */
    public NonPlayerCharacter(String name) throws IOException {
        super(name, new Inventory());
    }

    /**
     * To set the conversation, this is unavoidable otherwise the game can bug
     * @param look1
     * @param look2
     * @param talk1
     * @param talk2
     * @param attack1
     * @param attack2
     * @throws IOException
     */
    public void setConversationPath(String look1, String look2, String talk1, String talk2, String attack1, String attack2) throws IOException {
        this.look1 = TurtleFunction.getConversationNPC(look1);
        this.talk1 = TurtleFunction.getConversationNPC(talk1);
        this.attack1 = TurtleFunction.getConversationNPC(attack1);
        this.attack2 = TurtleFunction.getConversationNPC(attack2);
        this.look2 = TurtleFunction.getConversationNPC(look2);
        this.talk2 = TurtleFunction.getConversationNPC(talk2);
    }

    /**
     * To set the conversation, this is unavoidable otherwise the game can bug. This section take no attack file descriptor
     * @param look1
     * @param look2
     * @param talk1
     * @param talk2
     * @throws IOException
     */
    public void setConversationPath(String look1, String look2, String talk1, String talk2) throws IOException {
        this.look1 = TurtleFunction.getConversationNPC(look1);
        this.talk1 = TurtleFunction.getConversationNPC(talk1);
        this.look2 = TurtleFunction.getConversationNPC(look2);
        this.talk2 = TurtleFunction.getConversationNPC(talk2);
    }

    /**
     * To set a new talk
     * @param talk3
     * @throws IOException
     */
    public void setNewTalkPath(String talk3) throws IOException {
        this.talk2 = TurtleFunction.getConversationNPC(talk3);
    }

    /**
     * Get the description of the NPC
     * @return
     */
    public String getDescription(){
        if (this.firstTime){
            return longDescription;
        }
        else{
            return shortDescription;
        }
    }

    /**
     * Get the long description of a NPC
     * @return
     */
    public String getLongDescription() {
        return longDescription;
    }

    /**Set a First Time meet with the NPC*/
    public void lookedat(){
        this.firstTime = false;
    }

    /**
     * Attack the NPC if the NPC have a descriptor about it
     * @throws InterruptedException
     * @throws IOException
     */
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

    /**
     * This is a autormatique print section if the Hero look at the NPC
     * @throws InterruptedException
     */
    public void look() throws InterruptedException {
        if(firstTime) {
            TurtleFunction.print(this.look1);
            lookedat();
        }
        else
        TurtleFunction.print(this.look2);
    }

    /**
     * Set a Exit Location than the NPC can unlock to the hero if the hero talk to him.
     * @param e
     */
    public void setExitUnlockable(Exit e) {
        exitToUnlockTalking = e;
    }

    /**
     * This is the interaction between hero and NPC. This is the talk part.
     * @throws InterruptedException
     */
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

    /**
     * Set the boss and all dialog for the mini game.
     * @param bossCarac
     * @param forestMobs
     * @throws IOException
     */
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
