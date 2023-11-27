package com.utils;

import com.world.*;

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
 *      —GO location:   the GO command is followed by the name of the neighbor location the
 *                      player wants to go. In case the location exists and the exit can be crossed, the hero
 *                      goes there, otherwise he stays in the same room. In each case, a display will indicate
 *                      what happens.
 *      
 *      —HELP:          indicates the set of availaible commands.
 * 
 *      —LOOK[arguments]: displays a description of the current location if no argument
 *                      is given. In case a list of arguments is provided, a display of all arguments that can
 *                      be observed is given.
 * 
 *      —TAKE argument: add(if possible) the argument to the hero’s items.
 * 
 *      —QUIT:          quit the game.
 *      —USE arg1 [arg2]: uses the object arg1. In case a second argument is given, the first
 *                      one is used with the second. For example, use gun bullet may load the gun, which
 *                      can be used after that.
 * 
 *      —GETLOCATION :  Return the current location
 */

public class Command {

    /*
        COMMANDS :

        "GO",   //FINI
        "HELP", //Fini
        "LOOK", //Fini
        "TAKE", //Fini
        "USE",
        "GETEXIT", //Fini
        "ATTACK",
        "QUIT"  //Fini
        "LIST" //Fini
    */
    private static boolean alreadyInitialized = false;
    private static boolean thisIsTheEndBool;
    private static boolean gameOverVar;
    private static Location currentLocation;
    public static Scanner scanner;
    private static Hero ourSavior;

    public static void init(Location firstLocation, Hero hero) {
        if (!alreadyInitialized) {
            currentLocation = firstLocation;
            ourSavior = hero;
            thisIsTheEndBool = false;
            gameOverVar = false;
            alreadyInitialized = true;
            scanner = new Scanner(System.in);
        }
        else {
            System.out.println("Command has been initialized");
        }
    }

    public static void setThisIsTheEnd(boolean tite) {
        thisIsTheEndBool = tite;
    } 

    public static boolean isThisTheEnd() {
        return thisIsTheEndBool;
    }

    public static void setGameOver(boolean gameOverOrNot) {
        gameOverVar = gameOverOrNot;
    }

    public boolean isGameOver() {
        return gameOverVar;
    }

    public static void quit() {
        System.out.println("Quitting the game...");
        System.exit(0);
        Command.scanner.close();
    }

    public static Hero getHero() {
        return Command.ourSavior;
    }

    public static void help() {
        //Go
        System.out.println("GO : the GO command is followed by the name of the neighbor location the" + //
            " player wants to go. In case the location exists and the exit can be crossed, the hero" + //
            " goes there, otherwise he stays in the same room. In each case, a display will indicate" + //
            " what happens."
        );
        //Help
        System.out.println("HELP indicates the set of available commands.");
        //Look
        System.out.println("LOOK : displays a description of the current location if no argument is given," + //
        " or the specified item/person/room."
        );
        //Take
        System.out.println("TAKE : adds the specified item to the hero's inventory if it exists and can be taken."
        );
        //List
        System.out.println("LIST [ARG] : List all items of a location if arguments not given. The other argument accaptable is 'inventory' or 'all'."
        );
        //Quit
        System.out.println("QUIT : quit the game.");
        //GetExit
        System.out.println("GETLOCATION : returns the Exits the player can go.");
    }

    private static void go(Exit zone) throws InterruptedException {
        if(!zone.isLocked()) {
            Command.currentLocation = zone.getDestination();
            Command.currentLocation.goTo();
        }
        else{
            TurtleFunction.print("You cannot pass! Maybe you forgot something?");
        }
    }

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

    public static Location getCurrentLocation() {
        return Command.currentLocation;
    }

    public static void Interact(NonPlayerCharacter charac) throws InterruptedException {
        charac.interact();
    }

    public static void Interact(Item item) {
        item.use();
    }

    public static void command(String cmd) throws InterruptedException, RawItemNotAllowedException {
        
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

    private static void use(String string) throws InterruptedException {
        Inventory inv = ourSavior.getInventory();
        if(inv.isOnInventory(string))
        inv.useItem(string);
        else
        TurtleFunction.print("You can not use the " + string);
    }

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

    private static void list(String[] words) throws InterruptedException {
        if(words.length == 1) {
            Inventory inv = Command.currentLocation.getInventory();
            ArrayList<String> itemList = inv.getListItem();
            TurtleFunction.print("Voici une liste d'objets de \"" + Command.currentLocation.getName() + "\" :\n");
            for(int i=0 ; i < itemList.size() ; i++) {
                System.out.println(itemList.get(i));
            }
        } else if(words.length >= 2) {
            switch(words[1]) {

            case "inventory":
                Inventory inv = Command.ourSavior.getInventory();
                ArrayList<String> itemList = inv.getListItem();
                if(itemList.size() > 0)
                TurtleFunction.print("Voici une liste de l'inventaire de Babou :\n");
                else
                TurtleFunction.print("Babou n'a pas d'objet dans son inventaire.\n");
                for(int i=0 ; i < itemList.size() ; i++) {
                    System.out.println(itemList.get(i));
                }
                break;

            case "creature":
            ArrayList<NonPlayerCharacter> npcs = Command.currentLocation.getNPC();
                for(int i=0 ; i < npcs.size() ; i++) {
                    TurtleFunction.print(" - " + npcs.get(i).getName() + "\n");
                }
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

    private static void getexit() throws InterruptedException {
        TurtleFunction.print("You can go to : ");
        for(Exit e : Command.currentLocation.getExit().values()) {
            TurtleFunction.print("\n" + e.getDestination().getName());
        }
    }
}
