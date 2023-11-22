package com.world;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 */
public class Location {
    private String name;
    private Map<String, Exit> exits = new HashMap<>();
    private Inventory inventory;

    public Location(n String, exits Map<String, Exit>, inventory Inventory) {
        this.name = n;
        this.exits = exits;
        this.inventory = inventory;
    }

}
