package com.utils;

import com.world.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.characters.Hero;
import com.characters.NonPlayerCharacter;
import com.items.Inventory;
import com.items.Item;
import com.items.RawItemNotAllowedException;

/**
 * the player interacts with the game by entering a sequence of sentences.
 * As soon as the end_of_line character is entered,
 * the entire sentence is parsed. A well formed sentence will be of the
 * form COMMAND[ARGS], where COMMAND
 * is a game command, and ARGS is a list of (possibly empty) words.
 * Your game must handle at least the commands GO, HELP, LOOK, ATTACK, TAKE, USE, QUIT.
 * You are of course free to add as many commands as you wish. Your design should allow
 * you to add newcommands in a simple way. Here is a quick description of how the basic
 * commands work in a console:
 *     

GO :
    GO command is followed by the name of the neighbor location the
    player wants to go. In case the location exists and the exit can be crossed, the hero
    goes there, otherwise he stays in the same room. In each case, a display will indicate
    what happens."

USE ARG : 
    If the ARG is in hero's inventory, and if the item can be usable, you can use ARG 

HELP : 
    Indicates the set of available commands.

TALK ARG : 
    Talk to NPC.

ATTACK :
    Attack the Mobs/NPC, or maybe not.

LOOK :
    displays a description of the current location if no argument is given, or the 
    specified item/person

TAKE : 
    Adds the specified item to the hero's inventory if it exists and can be taken.

LIST [ARG] : 
    Lists all items of a location if arguments not given. The others arguments accaptable
    are 'inventory', 'all' and 'creature'.

QUIT : 
    Quit the game.

GETEXIT : 
    Returns the Exits the player can go.
 */

public class Command {
    
    private static boolean alreadyInitialized = false;
    private static boolean thisIsTheEndBool;
    private static boolean gameOverVar;
    private static Location currentLocation; // The current location of where the here is in real time
    public static Scanner scanner; // We had problem when we create too many Scanner, so we set one and only one scanner.
    private static Hero ourSavior; // The hero

    /**
     * Initialize all Commands. This is the nerve of all the game. In Command you can start like initialized some variable
     * There you set or get the Game Over variable
     * @param firstLocation
     * @param hero
     * @throws InterruptedException
     */
    public static void init(Location firstLocation, Hero hero) throws InterruptedException {
        if (!alreadyInitialized) {
            currentLocation = firstLocation;
            ourSavior = hero;
            thisIsTheEndBool = false;
            gameOverVar = false;
            alreadyInitialized = true;
            scanner = new Scanner(System.in);
            TurtleFunction.print("Tap enter when -> (Next) appear to continue the game.\n");
        }
        else {
            System.out.println("Command has been initialized");
        }
    }

    /**
     * Set The End to true or false
     * @param tite
     */
    public static void setThisIsTheEnd(boolean tite) {
        thisIsTheEndBool = tite;
    } 

    /**
     * Get the End or not with a boolean
     * @return
     */
    public static boolean isThisTheEnd() {
        return thisIsTheEndBool;
    }

    /**
     * Set if this a Game Over or Not
     * @param gameOverOrNot
     * @throws InterruptedException
     */
    public static void gameOver(boolean gameOverOrNot) throws InterruptedException {
        gameOverVar = gameOverOrNot;
        TurtleFunction.print("You lost the game...");
        Command.quit();
    }

    /**
     * Get the bool Game Over
     * @return
     */
    public boolean isGameOver() {
        return gameOverVar;
    }

    /**
     * Quit the game
     */
    public static void quit() {
        System.out.println("Quitting the game...");
        System.exit(0);
        Command.scanner.close();
    }

    /**
     * Return Hero
     * @return
     */
    public static Hero getHero() {
        return Command.ourSavior;
    }

    /**
     * Print all the help
     * @throws IOException
     */
    public static void help() throws IOException {
        ArrayList<String> helps = TurtleFunction.getConversationNPC("res/text/help.txt");
        for(String str : helps)
        System.out.println(str);
    }

    /**
     * Change the current location to another
     * @param zone
     * @throws InterruptedException
     */
    private static void go(Exit zone) throws InterruptedException {
        try{
            if(!zone.isLocked()) {
                Command.currentLocation = zone.getDestination();
                Command.currentLocation.goTo();
            }
            else{
                TurtleFunction.print("You cannot pass! Maybe you forgot something?");
            }
        } catch(NullPointerException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * This is a aux function to look
     * @param words
     * @return
     * @throws InterruptedException
     */
    private static boolean lookNPC(String[] words) throws InterruptedException {
        ArrayList<NonPlayerCharacter> npcs = currentLocation.getNPC();
        for (int i = 0; i < npcs.size(); i++) {
            if(npcs.get(i).getName().equalsIgnoreCase(words[1]))
            {
                npcs.get(i).look();
                return true;
            }
        }
        return false;
    }

    /**
     * Look if an item or a NPC is there. If true, print it
     * @param words
     * @throws InterruptedException
     */
    private static void look(String[] words) throws InterruptedException {
        if(words.length == 1) {
            String description = Command.currentLocation.getDescription();
            TurtleFunction.print(description);
        } 
        else if(words.length >= 2) {
            String description = Command.currentLocation.getDescriptionOfItem(words[1]);
            if(description != null)
            TurtleFunction.print(description);
            else {
                Inventory inv = Command.ourSavior.getInventory();
                description = inv.getDescriptionOf(words[1]);
                if (description != null) {
                    TurtleFunction.print(description + "This item is in the Babou inventory.");
                    return;
                }
                if(!lookNPC(words))
                TurtleFunction.print(words[1] + " is not exist.");               
            }
        }
    }

    /**
     * Return Current Location in Location object type
     * @return
     */
    public static Location getCurrentLocation() {
        return Command.currentLocation;
    }

    /**
     * Interact with a NPC
     * @param charac
     * @throws InterruptedException
     */
    public static void Interact(NonPlayerCharacter charac) throws InterruptedException {
        charac.interact();
    }

    /**
     * Interact with an Item
     * @param item
     */
    public static void Interact(Item item) {
        item.use();
    }

    /**
     * This is the principal static method of Command. You enter a severals words separates with a space and it test all word in order to make a command. 
     * @param cmd
     * @throws InterruptedException
     * @throws RawItemNotAllowedException
     * @throws IOException
     */
    public static void command(String cmd) throws InterruptedException, RawItemNotAllowedException, IOException {
        
        String[] words = cmd.split(" ");
        switch (words[0].toLowerCase()) {
            case "go":
                if (words.length == 2) {
                    for (Exit e: currentLocation.getExit().values()) {
                        if (e.getDestination().getName().equalsIgnoreCase(words[1])) {
                            go(e);
                            return;
                        }
                    }
                    if(Command.currentLocation.getName().equalsIgnoreCase(words[1]))
                    System.out.println("You are already here!");
                    else
                    TurtleFunction.print("That direction doesn't exist! Write 'getexit' to know were you can go.");
                }
                else {
                    TurtleFunction.print("'go' takes one argument. Write 'getexit' to know were you can go.");
                }
                break;
            
            case "help":
                Command.help();
                break;

            case "look":
                Command.look(words);
                break;

            case "talk":
                Command.talk(words);
                break;
                
            case "take":
                if(words.length >= 2) {
                    take(words[1]);
                } 
                else {
                    TurtleFunction.print("'Take' takes 1 more argument.");
                }
                break;

            case "use":
                if(words.length == 2)
                Command.use(words[1]);
                else
                TurtleFunction.print("Use requires one argument. Write 'help' to see what you can do with 'Use'.");
                break;

            case "attack":
                Command.attack(words);
                break;

            case "list":
                Command.list(words);
                break;

            case "quit":
                Command.quit();
                break;
            
            case "getexit":
                Command.getexit();
                break;

            default:
                if(words[0].equalsIgnoreCase(""))
                TurtleFunction.print("Command is empty. Write help if you do not know the commands.");
                else
                TurtleFunction.print("\"" + words[0].toLowerCase() + "\" is a unknown command. Write 'help' to know all commands available.");
                break;
        }
    }

    /**
     * Attack a NPC, it takes one argument, no less, no more
     * @param words
     * @throws InterruptedException
     * @throws IOException
     * @throws RawItemNotAllowedException
     */
    private static void attack(String[] words) throws InterruptedException, IOException, RawItemNotAllowedException {
        if(words.length == 2) {
            ArrayList<NonPlayerCharacter> npcs = currentLocation.getNPC();
            for (int i = 0; i < npcs.size(); i++) {
                if(npcs.get(i).getName().equalsIgnoreCase(words[1]))
                {
                    npcs.get(i).attack();
                    return;
                }
            }
            TurtleFunction.print("Maybe " + words[1] + "does not exist here.");
        }
        else
        TurtleFunction.print("Attack takes only one argument : The NPC target");
    }

    /**
     * Talk to NPC, you can, if you want, speak with 'me', 'npc', 'kiddo' or 'any' but Turtle does not promise this will work perfectly with what you want.
     * @param words
     * @throws InterruptedException
     */
    private static void talk(String[] words) throws InterruptedException {
        switch(words[1]) {
            case "npc":
                TurtleFunction.print("If you do not know who is there, try this 'list creature'. Don't thanks me.");
                break;
            case "me":
                TurtleFunction.print("This is lovely, but i cannot speak, i'm a Turtle after all. Talk to another one.");
                break;
            case "kiddo":
            case "kid":
            case "minime":
                TurtleFunction.print("Why do you want to speek to youself??");
                break;
            case "any":
            case "anyone":
            case "anybody":
                TurtleFunction.print("Sorry, at this rate i can not help you. No ! Command help can you, not me.");
                break;
            default:
                ArrayList<NonPlayerCharacter> npcs = currentLocation.getNPC();
                for (int i = 0; i < npcs.size(); i++) {
                    if(npcs.get(i).getName().equalsIgnoreCase(words[1]))
                    {
                        npcs.get(i).interact();
                        return;
                    }
                }
                TurtleFunction.print("Try 'list creature' to know who to speak with. " + words[1] + " is not there.");
                break;
        }
    }

    /**
     * Use an item if only item within inventory
     * @param string
     * @throws InterruptedException
     */
    private static void use(String string) throws InterruptedException {
        Inventory inv = ourSavior.getInventory();
        if(inv.isOnInventory(string))
        inv.useItem(string);
        else
        TurtleFunction.print("You can not use the " + string);
    }

    /**
     * Take a object in area location
     * @param string
     * @throws RawItemNotAllowedException
     * @throws InterruptedException
     */
    private static void take(String string) throws RawItemNotAllowedException, InterruptedException {
        Inventory inv = Command.currentLocation.getInventory();
        Item picked;
        if(inv.isOnInventory(string) && inv.isPickable(string)) {
            picked = inv.pickItem(string);
            ourSavior.addItem(picked);
            TurtleFunction.print("You picked the " + string);
            return;
        }
        
        else if(!inv.isOnInventory(string))  {
            TurtleFunction.print(string + " does not exist in this place.");
            return;
        }
        if(!inv.isPickable(string)) {
            TurtleFunction.print("You can not take " + string + ".");
            return;
        }
    }

    /**
     * List can take 1 or 0 arguments. The arguments allowed are 'inventory', 'creature', 'all'
     * @param words
     * @throws InterruptedException
     */
    private static void list(String[] words) throws InterruptedException {
        if(words.length == 1) {
            Inventory inv = Command.currentLocation.getInventory();
            ArrayList<String> itemList = inv.getListItem();
            TurtleFunction.print("This a object list of  \"" + Command.currentLocation.getName() + "\" :\n");
            for(int i=0 ; i < itemList.size() ; i++) {
                System.out.println(itemList.get(i));
            }
        } else if(words.length >= 2) {
            switch(words[1]) {

            case "inventory":
                Inventory inv = Command.ourSavior.getInventory();
                ArrayList<String> itemList = inv.getListItem();
                if(itemList.size() > 0)
                TurtleFunction.print("This a object list of Kiddo :\n");
                else
                TurtleFunction.print("Kiddo has no item in inventory.\n");
                for(int i=0 ; i < itemList.size() ; i++) {
                    System.out.println(itemList.get(i));
                }
                break;

            case "creature":
                ArrayList<NonPlayerCharacter> npcs = Command.currentLocation.getNPC();
                if(npcs.size() > 0) {
                    for(int i=0 ; i < npcs.size() ; i++) {
                        TurtleFunction.print(" - " + npcs.get(i).getName() + "\n");
                    }
                } 
                else TurtleFunction.print("No Creature here, except you.");
                break;

            case "all":
                Inventory inv1 = Command.ourSavior.getInventory();
                Inventory inv2 = Command.currentLocation.getInventory();
                ArrayList<String> itemListLocation = inv2.getListItem();
                ArrayList<String> itemListHero = inv1.getListItem();
                TurtleFunction.print("Voici une liste d'objets de \"" + Command.currentLocation.getName() + "\" :\n");
                for(int i=0 ; i < itemListLocation.size() ; i++) {
                    TurtleFunction.print(" - " + itemListLocation.get(i) + "\n");
                }
                TurtleFunction.print("---\nVoici une liste de l'inventaire de Babou :\n");
                for(int i=0 ; i < itemListHero.size() ; i++) {
                    TurtleFunction.print(" - " + itemListHero.get(i) + "\n");
                }
            }
        }
    }

    /**
     * Print all exits possible
     * @throws InterruptedException
     */
    private static void getexit() throws InterruptedException {
        TurtleFunction.print("You can go to : ");
        for(Exit e : Command.currentLocation.getExit().values()) {
            TurtleFunction.print("\n" + e.getDestination().getName());
        }
    }
}
