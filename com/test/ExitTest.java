package com.test;

import java.io.IOException;

import com.world.Exit;
import com.world.Location;

public class ExitTest {
    Exit exit;
    Location loc;
    public ExitTest() throws IOException {
        loc = new Location("test", "com\\test\\test_text");
        exit = new Exit("test", "Description");

        //test
        System.out.println(exit);
        unlockTest();
        setMessageIfLockedTest();
        messageForLockedExit();
        getDescriptionTest();
        setDestination();
        getDestinationTest();
    }

    public void unlockTest() {
        exit.unlock();
    }

    public void setMessageIfLockedTest() {
        exit.setMessageIfLocked("New Message");
    }

    public void messageForLockedExit() {
        exit.messageForLockedExit();
    }

    public void getDescriptionTest() {
        System.out.println(exit.getDescription());
    }

    public void getDestinationTest() {
        System.out.println(exit.getDestination().getName());
    }

    public void setDestination() {
        exit.setDestination(loc);
    }

    public void isLockedTest() {
        if (exit.isLocked()) {
            System.out.println("The door is locked.");
        } else {
            System.out.println("The door is not locked.");
        }
    }
}
