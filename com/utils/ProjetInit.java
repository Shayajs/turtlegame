package com.utils;

import com.world.*;
import com.items.*;
//import com.items.unwieldy.*;
import com.items.wieldy.other.*;
//import com.items.wieldy.tool.*;
//import com.items.wieldy.weapon.*;
public class ProjetInit {
    public static void init() throws RawItemNotAllowedException {
        /*
        Initialisation of global variables
        
        First of all, it start with creation of element for the locations :
        - Exits
        - NPC already in the location
        - Objects
        - A description 
        */ 

        //Bunker
        Exit bunkerToHouse = new Exit("B2H", "This is an exit to go to House from Bunker");
        Item familyPortrait = new FamilyPortrait("Family Portrait", "This a family portrait of Hero Family, maybe dead at this time..."); 
        String bunkerShortDescription = "This place is a bunker, cold and dark.";
        String bunkerLongDescription = "This place is a bunker. The hero can ";
        Location firstLocation = new Location("Bunker", bunkerShortDescription, bunkerLongDescription);
        firstLocation.addItems(familyPortrait);
        firstLocation.addExit(bunkerToHouse);
    }
}
