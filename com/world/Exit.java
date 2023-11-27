package com.world;

public class Exit {
    private String name;
    private String messageIfLocked = null;
    private Location destination;
    private String description;
    private boolean locked;

    public Exit(String name, Location location, String description, boolean closed){
        this.name = name;
        this.destination = location;
        this.locked = closed;
        this.description = description;
    }

    public Exit(String name, Location location, String description){
        this.name = name;
        this.destination = location;
        this.locked = true;
        this.description = description;
    }

    public Exit(String name, String description){
        this.name = name;
        this.locked = true;
        this.description = description;
    }

    public void unlock(){
        this.locked = false;
    }

    public void setMessageIfLocked(String message) {
        this.messageIfLocked = message;
    }

    public String messageForLockedExit() {
        if(messageIfLocked != null) {
            return messageIfLocked;
        }
        else {
            return "This emplacement cannot be accessed. Maybe you forgot something?";
        }
    }

    public Location getDestination(){
        return this.destination;
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public void setDestination(Location location) {
        this.destination = location;
    }

    public boolean isLocked() {
        return this.locked;
    }
}