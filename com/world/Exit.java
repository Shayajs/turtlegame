package com.world;

public class Exit {
    private Location destination;
    private String description;
    private boolean locked;

    public Exit(Location location, String description, boolean closed){
        this.destination = location;
        this.locked = closed;
        this.description = description;
    }

    public Exit(Location location, String description){
        this.destination = location;
        this.locked = true;
        this.description = description;
    }

    public void unlock(){
        this.locked = false;
    }
    public Location getDestination(){
        return this.destination;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isLocked() {
        return this.locked;
    }
}