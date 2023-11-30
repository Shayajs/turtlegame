package com.test;

import java.io.IOException;

import com.items.RawItemNotAllowedException;

public class Unitest {
    public Unitest() throws IOException, InterruptedException, RawItemNotAllowedException {
        System.out.println("Unitest");
        //NonPlayerCharacterTest
        new NonPlayerCharacterTest();
        //Item
        new ItemTest();
        //Inventory
        new InventoryTest();
        //Exit
        new ExitTest();
        //Location
        new LocationTest();
        //TurtleFunction
        new TurtleFunctionTest();
        //Command
        new CommandTest();
    }
}
