package com.test;

import java.io.IOException;

import com.characters.NonPlayerCharacter;
import com.items.RawItemNotAllowedException;
import com.items.wieldy.tool.Diary;
import com.world.Exit;
import com.world.Location;

public class LocationTest {
    Location loc;

    public LocationTest() throws IOException, RawItemNotAllowedException, InterruptedException {
        loc = new Location("test", "com/test/LocationTest.java");
        
        //Tests
        addExitTest();
        addItemTest();
        addNPCTest();
        
        getDescriptionTest();
        getExitTest();
        getInventoryTest();
        getNPC();
        goToTest();
        lookTest();
        takeTest();
    }

    public void addNPCTest() throws IOException {
        loc.addNPC(new NonPlayerCharacter("Test"));
    }

    public void addItemTest() throws RawItemNotAllowedException {
        loc.addItem(new Diary("test"));
    }

    public void addExitTest() {
        loc.addExit(new Exit("test", "Description"));
    }

    public void getDescriptionTest() {
        loc.getDescription();
    }

    public void getNPC()  {
        loc.getNPC().toString();
    }

    public void getExitTest() {
        loc.getExit();
    }

    public void lookTest() throws InterruptedException {
        loc.look();
    }

    public void takeTest() {
        loc.take("test");
    }

    public void getInventoryTest() {
        loc.getInventory();
    }

    public void goToTest() throws InterruptedException {
        loc.goTo();
    }
}
