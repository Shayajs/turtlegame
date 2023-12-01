package com.utils;

import com.world.*;

import java.io.IOException;

import com.characters.Hero;
import com.characters.NonPlayerCharacter;
import com.items.*;
import com.items.unwieldy.*;
import com.items.wieldy.other.*;
import com.items.wieldy.tool.*;
//import com.items.wieldy.weapon.*;
public class ProjetInit {
    /**
     * Initialisation of global variables, command variables too.
        
        It starts with the creation of all NPC.
        It mades after that a creation of element for the locations :
        - Exits
        - NPC already in the location
        - Objects
        - A description
        - Set the location an available exit
        And the location obviously.
     * @throws RawItemNotAllowedException
     * @throws IOException
     * @throws InterruptedException
     */ 
    public static void init() throws RawItemNotAllowedException, IOException, InterruptedException {

        // OUUUUR HEROOOOO !
        Hero babou = new Hero("Babou", new Inventory());
        
        //All the NPC
        NonPlayerCharacter mushroomBrothers = new NonPlayerCharacter("Mushrooms");
        NonPlayerCharacter rabbit = new NonPlayerCharacter("Rabbit");
        NonPlayerCharacter frog = new NonPlayerCharacter("Frog");
        NonPlayerCharacter dinolou = new NonPlayerCharacter("Dinolou");
        NonPlayerCharacter monkey = new NonPlayerCharacter("Monkey");
        NonPlayerCharacter butt = new NonPlayerCharacter("Butt");
        NonPlayerCharacter turtle2 = new NonPlayerCharacter("Turtle2");

        //Set files to NPC
        mushroomBrothers.setConversationPath(
            "res/text/Street/look1_mushrooms.txt",
            "res/text/Street/look2_mushrooms.txt",
            "res/text/Street/talk1_mushrooms.txt",
            "res/text/Street/talk2_mushrooms.txt",
            "res/text/Street/attack1_mushrooms.txt",
            "res/text/Street/attack2_mushrooms.txt"
        );

        rabbit.setConversationPath(
            "res/text/Forest/look_rabbit.txt",
            "res/text/Forest/look_rabbit.txt",
            "res/text/Forest/talk1_rabbit.txt",
            "res/text/Forest/talk2_rabbit.txt"
        );

        frog.setConversationPath(
            "res/text/Forest/look_frog.txt",
            "res/text/Forest/look_frog.txt",
            "res/text/Forest/talk1_frog.txt",
            "res/text/Forest/talk2_frog.txt"
        );

        dinolou.setConversationPath(
            "res/text/Forest/look_dino.txt",
            "res/text/Forest/look_dino.txt",
            "res/text/Forest/talk1_dino.txt",
            "res/text/Forest/talk2_dino.txt"
        );

        monkey.setConversationPath(
            "res/text/OldBank/look_monkey.txt",
            "res/text/OldBank/look_monkey.txt",
            "res/text/OldBank/talk1_monkey.txt",
            "res/text/OldBank/talk2_monkey.txt"
        );

        butt.setConversationPath(
            "res\\text\\SecretVillage\\look_butt.txt",
            "res\\text\\SecretVillage\\look_butt.txt",
            "res\\text\\SecretVillage\\talk_butt.txt",
            "res\\text\\SecretVillage\\talk_butt.txt"
        );

        turtle2.setConversationPath(
            "res\\text\\SecretVillage\\look_turtle2.txt",
            "res\\text\\SecretVillage\\look_turtle2.txt",
            "res\\text\\SecretVillage\\talk_turtle2.txt",
            "res\\text\\SecretVillage\\talk_turtle2.txt"
        );

        // ---- Bunker ----
        /* In order :
         * - Creation of only 1 exit : The House
         * - Add Items
         * - Add these objects to Location and add 2 types of Description : A short and a long one.
         */
        Exit bunkerToHouse = new Exit("B2H", "This is an exit to go to House from Bunker.");
        bunkerToHouse.unlock(); //The exit is natively unlock
        Item diary = new Diary("Diary", "This diary is up to the desk. It belonging to the kiddo's father");
        Item bed = new Bed("Bed");
        Item desk = new Desk("Desk");
        Item storageShelf = new Shelf("StorageShelf");
        Item door = new Door("Door");
        Location bunker = new Location("bunker", "res/text/Bunker/");
        
        bed.setDescriptionFile("res\\text\\Bunker\\look_beddingArea.txt");
        desk.setDescriptionFile("res\\text\\Bunker\\look_desk.txt");
        door.setDescriptionFile("res\\text\\Bunker\\look_door.txt");
        storageShelf.setDescriptionFile("res\\text\\Bunker\\look_shelf.txt");
        door.setDescriptionFile("res\\text\\Bunker\\look_door.txt");
        
        bunker.addItem(diary);
        bunker.addItem(storageShelf);
        bunker.addItem(bed);
        bunker.addItem(desk);
        bunker.addItem(door);
        bunker.addExit(bunkerToHouse);

        // ---- House ----
        /*
         * In order :
         * - Creation of 2 exits : to Bunker and to Street (Street is locked)
         * - Add Items
         * - Add these objects to Location and add 2 types of Description : A short and a long one.
         * - Explain to bunker than the house is an available exit.
         */
        Exit houseToBunker = new Exit("H2B", bunker, "This is an exit to go to Bunker from House.");
        houseToBunker.unlock();
        Exit houseToStreet = new Exit("H2S", "This is an exit to go to Street from House.");
        Item familyPortrait = new FamilyPortrait("FamilyPortrait");
        Item key = new Key("key");
        Item slideboard = new Sideboard("Sideboard");
        Location house = new Location("ruinedHouse", "res\\text\\RuinedHouse");
        
        key.setDescriptionFile("res\\text\\RuinedHouse\\look_key.txt");
        familyPortrait.setDescriptionFile("res\\text\\RuinedHouse\\look_picture.txt");
        slideboard.setDescriptionFile("res\\text\\RuinedHouse\\look_sideboard.txt");
        
        house.addItem(key);
        house.addItem(familyPortrait);
        house.addItem(slideboard);
        house.addExit(houseToBunker);
        house.addExit(houseToStreet);
        bunkerToHouse.setDestination(house); //House is now set, we can add it in an exit.
        
        //Street
        /*
         * In order :
         * - Creation of 3 exits : to House, to Forest and to Bank (The last two are locked)
         * - Add Items : A poster and a stone, useless stone.
         * - Add NPC : Mushroom Brothers
         * - Add these objects to Location and add 2 types of Description : A short and a long one.
         * - Explain to house than the forest is an available exit.
         */
        Exit streetToHouse = new Exit("S2H", house, "This is an exit to go to House from Street.");
        streetToHouse.unlock();
        Exit streetToForest = new Exit("S2F", "This is an exit to go to Forest from Street.");
        Exit streetToBank = new Exit("S2B", "You cannot go to the bank before going in forest.");
        Item stone = new Stone("Stone", "An useless stone in the street.");
        Item poster = new Poster("poster");
        poster.setDescriptionFile("res\\text\\Street\\look_poster.txt");
        Location street = new Location("street", "res\\text\\Street");

        poster.setDescriptionFile("res\\text\\Street\\look_poster.txt");

        street.addNPC(mushroomBrothers); //The famouse Mushroom Brothers
        street.addItem(poster);
        street.addItem(stone);
        street.addExit(streetToHouse);
        street.addExit(streetToForest);
        street.addExit(streetToBank);
        houseToStreet.setDestination(street); //The hero can now go to the street from the house.
        
        //Forest
        /*
         * In order :
         * - Creation of 2 exits : to Street and to Secret Forest (The last one is locked)
         * - Add 2 Items unwieldy : Not a Rock, THE Rock, a big one and a branch (decoration).
         * - Add 3 NPC : A rabbit, a frog and DINOLOU !
         * - Add these six objects to Location and add 2 types of Description : A short and a long one.
         * - We explain to street than the forest is an available exit.
         */
        Exit forestToStreet = new Exit("F2S", street, "This is an exit to Street from Forest.");
        forestToStreet.unlock();
        Exit forestToSecretForest = new Exit("F2SF", "You cannot go there without the secret item.");
        Item rock = new TheRock("Rock", "Not a Rock, THE Rock, a big one");
        Item branch = new Branch("Branch", "Just a dead branch in the ground.");
        Location forest = new Location("forest", "res\\text\\Forest");
        forest.addItem(rock);
        forest.addItem(branch);
        forest.addExit(forestToStreet);
        forest.addExit(forestToSecretForest);
        forest.addNPC(rabbit);
        forest.addNPC(dinolou);
        forest.addNPC(frog);
        streetToForest.setDestination(forest); //The hero can now go to the forest from the street.

        //Bank
        /*
         * In order :
         * - Creation of 1 exit : The street
         * - Add 2 items : A Bench (unwieldy) and a money coin (wieldy)
         * - Add 1 NPC, the boss : A monkey, a.k.a. Lazy Monkey in the thug street
         * - Add these six objects to Location and add 2 types of Description : A short and a long one.
         * - Explain to street than the Bank is available.
         */
        Exit bankToStreet = new Exit("B2S", street, "This is an exit to go back to Street from Bank.");
        bankToStreet.unlock();
        Item bench = new Bench("Bench", "It's not very comfortable but it will help you if you fall down.");
        Item moneyCoin = new Money("Money");
        Item chart = new Chart("Chart");
        Location bank = new Location("oldBank", "res\\text\\OldBank");

        moneyCoin.setDescriptionFile("res\\text\\OldBank\\look_money.txt");
        chart.setDescriptionFile("res\\text\\OldBank\\look_chart.txt");

        bank.addItem(bench);
        bank.addItem(moneyCoin);
        bank.addItem(chart);
        bank.addNPC(monkey);
        bank.addExit(bankToStreet);
        streetToBank.setDestination(bank); //The hero can now go to the bank from the street.

        //Secret Village
        /*
        * In order :
        * - Creation of 1 exit : To Forest
        * - No Item, this this the happy end.
        * - No NPC, no problem.
        * - This location has only a description.
        * - Explain to forest than the Secret Village is available 
        */
        Exit secretVillageToForest = new Exit("V2F", forest, "This is an exit to Forest from Secret Forest.");
        Location secretVillage = new Location("secretVillage","res\\text\\SecretVillage");
        secretVillage.addExit(secretVillageToForest);
        secretVillage.addNPC(turtle2);
        secretVillage.addNPC(butt);

        // Initialization of all others commands
        Command.init(bunker, babou); //Bunker is the first location

        //This npc can make available the forest location
        mushroomBrothers.setExitUnlockable(streetToForest);
        //This npc can make available the bank location
        dinolou.setExitUnlockable(streetToBank);

        //Boss Bank
        NonPlayerCharacter.setBoss(monkey, forest.getNPC());
        Item hoglet = new Hoglet("Hoglet", "A cute Hoglet.");
        monkey.addItem(hoglet);
    }

    /**
     * Start the game
     * @throws IOException
     * @throws InterruptedException
     * @throws RawItemNotAllowedException
     */
    public static void start() throws IOException, InterruptedException, RawItemNotAllowedException {
        Command.getCurrentLocation().goTo();
        do {
            TurtleFunction.print("\nWhat do you want to do? cmd: ");
            String userInput = Command.scanner.nextLine();
            Command.command(userInput);
        }while(!Command.isThisTheEnd());
    }
}
