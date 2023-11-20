package com.utils;

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
 *      —TAKE argument: add(ifpossible) the argument to the hero’s items.
 * 
 *      —QUIT:          quit the game.
 *      —USE arg1 [arg2]: uses the object arg1. In case a second argument is given, the first
 *                      one is used with the second. For example, use gun bullet may load the gun, which
 *                      can be used after that.
 */
public class Commands {
    
}
