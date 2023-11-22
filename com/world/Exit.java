package com.world;

public class Exit {
    private Location destination;
    private String description;
    private boolean locked;
    public Exit(Location l, String description, boolean closed ){
        this.destination = l;
        this.locked = closed;
    }

    public void unlock(){
        this.locked = false;
    }
    public Location getDestination(){
        return this.destination;
    }
}