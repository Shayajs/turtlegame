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
     * "Items" regroup all informations of an item object. 
     * This constructor create an object with name and with an id instanced
     * @param name
     * @param id
     */
    public Items(String name, short id) {
        this.name = name;
        this.idItem = id;
        this.description = "An object named " + name + ".";
    }

    /**
     * "Items" regroup all informations of an item object. 
     * This constructor create an object with name, an id instanced and a unique description
     * @param name
     * @param id
     * @param description
     */
    public Items(String name, short id, String description) {
        this.name = name;
        this.idItem = id;
        this.description = description;
    }

    /**
     * This private method add an id to the item
     * @return Math.random
     */
    private short getNewID() {
        return (short)(Math.random() * 1000);
    }

    /**
     * Get the name of the item
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the identification of the item
     * @return
     */
    public short getID() {
        return this.idItem;
    }

    /**
     * Get the description of the item 
     */
    public String toString() {
        return this.description;
    }
}
