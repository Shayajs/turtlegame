package com.utils;

import com.world.*;

import java.util.Scanner;

import com.characters.Hero;
import com.items.Item;

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
        "LOOK",
        "TAKE",
        "USE",
        "GETLOCATION", //Fini
        "ATTACK",
        "QUIT"  //Fini
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
        //Quit
        System.out.println("QUIT : quit the game.");
    }

    public static void go(Exit zone) throws InterruptedException {
        if(!zone.isLocked()) {
            Command.currentLocation = zone.getDestination();
            TurtleFunction.printConversation(Command.currentLocation.getDescription());
        }
        else{
            TurtleFunction.printConversation("You cannot pass! Maybe you forgot something?");
        }
    }

    public static void look(Item item) {
        if (item != null) {
            System.out.println("\n\"" + item.getName().toUpperCase() + "\" :\n" + item.getDescription());
        } else {
                System.out.println("There's nothing here!");
        }
        return;
    }

    public static Location getCurrentLocation() {
        return Command.currentLocation;
    }

    public static void Interact(Character charac) {

    }

    public static void Interact(Item item) {

    }

    public static void command(String cmd) throws InterruptedException {
        
        String[] words = cmd.split(" ");
        switch (words[0].toLowerCase()) {
            case "go":
                if (words.length == 2) {
                    for (Exit e: currentLocation.getExit().values()) {
                        if (e.getDestination().getName().equalsIgnoreCase(words[1]))
                        go(e);
                    }
                }
                break;
            
            case "help":
                Command.help();
                break;

            case "look":
                break;

            case "take":
                break;

            case "use":
                break;

            case "attack":
                break;

            case "quit":
            Command.quit();
                break;

            default:
                System.out.println("\"" + words[0].toLowerCase() + "\" is  a unknown command");
                break;
        }
    }
}
