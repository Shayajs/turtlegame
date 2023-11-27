package com.utils;

import com.world.*;

import java.io.IOException;

import com.characters.NonPlayerCharacter;
import com.items.*;
import com.items.unwieldy.*;
import com.items.wieldy.other.*;
import com.items.wieldy.tool.Diary;
import com.items.wieldy.tool.*;
//import com.items.wieldy.weapon.*;
public class ProjetInit {
    public static void init() throws RawItemNotAllowedException, IOException {
        /*
        Initialisation of global variables, command variables too.
        
        It starts with the creation of all NPC.
        It mades after that a creation of element for the locations :
        - Exits
        - NPC already in the location
        - Objects
        - A description
        - Set the location an available exit
        And the location obviously.
        */ 

        //All the NPC
        NonPlayerCharacter mushroomBrothers = new NonPlayerCharacter("MushroomBrothers");
        NonPlayerCharacter rabbit = new NonPlayerCharacter("Rabbit");
        NonPlayerCharacter frog = new NonPlayerCharacter("Frog");
        NonPlayerCharacter dinolou = new NonPlayerCharacter("Dinolou");
        NonPlayerCharacter monkey = new NonPlayerCharacter("Monkey");

        // ---- Bunker ----
        /* In order :
         * - Creation of only 1 exit : The House
         * - Add 1 Item : The father diary
         * - Add these two objects to Location and add 2 types of Description : A short and a long one.
         */
        Exit bunkerToHouse = new Exit("B2H", "This is an exit to go to House from Bunker.");
        bunkerToHouse.unlock(); //The exit is natively unlock
        Item diary = new Diary("Diary", "This diary belonging to the hero's father");
        String bunkerShortDescription = "This place is a bunker, cold and dark.";
        String bunkerLongDescription = "";
        Location bunker = new Location("Bunker", bunkerShortDescription, bunkerLongDescription);
        bunker.addItem(diary);
        bunker.addExit(bunkerToHouse);

        //Bunker is the first location

        // ---- House ----
        /*
         * In order :
         * - Creation of 2 exits : to Bunker and to Street (Street is locked)
         * - Add 2 Items : A family portrait and the key to go out.
         * - Add these four objects to Location and add 2 types of Description : A short and a long one.
         * - Explain to bunker than the house is an available exit.
         */
        Exit houseToBunker = new Exit("H2B", bunker, "This is an exit to go to Bunker from House.");
        Exit houseToStreet = new Exit("H2S", "This is an exit to go to Street from House.");
        Item familyPortrait = new FamilyPortrait("Family Portrait", "This a family portrait of Hero Family, maybe dead at this time...");
        Item key = new Key("Key", "This key maybe unlock the house entrance.");
        String houseShortDescription = "This place is the main house of the family's hero.";
        String houseLongDescription = "";
        Location house = new Location("House", houseShortDescription, houseLongDescription);
        house.addItem(key);
        house.addItem(familyPortrait);
        house.addExit(houseToBunker);
        house.addExit(houseToStreet);
        bunkerToHouse.setDestination(house); //House is now set, we can add it in an exit.
        
        //Street
        /*
         * In order :
         * - Creation of 3 exits : to House, to Forest and to Bank (The last two are locked)
         * - Add 2 Items : A poster and a stone, useless stone.
         * - Add 1 NPC : Mushroom Brothers
         * - Add these six objects to Location and add 2 types of Description : A short and a long one.
         * - Explain to house than the forest is an available exit.
         */
        Exit streetToHouse = new Exit("S2H", house, "This is an exit to go to House from Street.");
        streetToHouse.unlock();
        Exit streetToForest = new Exit("S2F", "This is an exit to go to Forest from Street.");
        Exit streetToBank = new Exit("S2B", "You cannot go to the bank before going in forest.");
        String streetShortDescription = "This place is a small town where Hero lives";
        String streeLongDescription = "";
        Item stone = new Stone("Stone", "An useless stone in the street.");
        Item poster = new Poster("Poster", "A poster in a street with \"Down with capitalism!\".");
        Location street = new Location("Street", streetShortDescription, streeLongDescription);
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
        String forestShortDescription = "";
        String forestLongDescription = "";
        Item rock = new TheRock("Rock", "Not a Rock, THE Rock, a big one");
        Item branch = new Branch("Branch", "Just a dead branch in the ground.");
        Location forest = new Location("Forest", forestShortDescription, forestLongDescription);
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
        String bankShortDescription = "In this place you can find some money.";
        String bankLongDescription = "There are many people here who want to steal your money.";
        Item bench = new Bench("Bench", "It's not very comfortable but it will help you if you fall down.");
        Item moneyCoin = new Money("Money Coin", "It contains 50$");
        Location bank = new Location("Bank", bankShortDescription, bankLongDescription);
        bank.addItem(bench);
        bank.addItem(moneyCoin);
        bank.addNPC(monkey);
        bank.addExit(bankToStreet);
        streetToBank.setDestination(bank); //The hero can now go to the bank from the street.

        //Secret Forest
        /*
        * In order :
        * - Creation of 1 exit : To Forest
        * - No Item, this this the happy end.
        * - No NPC, no problem.
        * - This location has only a description.
        * - Explain to forest than the Secret Forest is available 
        */
        Exit secretForestToForest = new Exit("SF2F", forest, "This is an exit to Forest from Secret Forest.");
        String secretForestShortDescription = "";
        String secretForestLongDescription = "";
        Location secretForest = new Location("Secret Forest", secretForestShortDescription, secretForestLongDescription);
        secretForest.addExit(secretForestToForest);

        // Initialization of all others commands
        Command.init(bunker);

    }
}
