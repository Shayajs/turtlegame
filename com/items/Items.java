package com.items;

import java.lang.Math;

public class Items {

    private String name;
    private short idItem;
    private String description;

    /**
     * "Items" regroup all informations of an item object. 
     * This constructor create an object only with name
     * @param name
     */
    public Items(String name) {
        this.name = name;
        this.idItem = this.getNewID();
        this.description = "An object named " + name + ".";
    }

    /**
     * "Items" regroup all informations of an item object. 
     * This constructor create an object with name and with a unique description
     * @param name
     * @param description
     */
    public Items(String name, String description) {
        this.name = name;
        this.description = description;
        this.idItem = this.getNewID();
    }

    /**
     * This private method add an id to the item
     * @return Math.random
     */
    private short getNewID() {
        return (short)(Math.random() * 1000);
    }

    public String toString() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public short getID() {
        return this.idItem;
    }
}
