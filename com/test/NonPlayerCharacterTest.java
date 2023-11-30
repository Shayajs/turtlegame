package com.test;

import java.io.IOException;

import com.characters.NonPlayerCharacter;
import com.items.Inventory;

public class NonPlayerCharacterTest {
    
    NonPlayerCharacter npc;

    public final void testNonPlayerCaracter() throws IOException {
        // First constructor
        npc = new NonPlayerCharacter("Test", new Inventory());
        // Second Constructor
        npc = new NonPlayerCharacter("Test");
    }

    public final void testGetName() {
        String name = npc.getName();
        System.out.println(name);
    }
}
