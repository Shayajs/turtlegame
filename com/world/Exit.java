package com.world;

public class Exit {
    private Location destination;
    public Exit(Location l){
        this.destination = l;
    }

    public Location getDestination(){
        return this.destination;
    }
}
