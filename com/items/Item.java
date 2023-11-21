
package com.items;

import java.lang.Math;

public abstract class Item {

    private String name;
    private short idItem;
    private String description;

    /**
     * Constructor to create an item object with a name.
     * A unique id is generated and a default description is set.
     * @param name
     */
    public Item(String name) {
        this.name = name;
        this.idItem = this.getNewID();
        this.description = "An object named " + name + ".";
    }

    /**
     * Constructor to create an item object with a name and a description.
     * A unique id is generated.
     * @param name
     * @param description
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        this.idItem = this.getNewID();
    }

    /**
     * Constructor to create an item object with a name and a specified id.
     * A default description is set.
     * @param name
     * @param id
     */
    public Item(String name, short id) {
        this.name = name;
        this.idItem = id;
        this.description = "An object named " + name + ".";
    }

    /**
     * Constructor to create an item object with a name, a specified id, and a description.
     * @param name
     * @param id
     * @param description
     */
    public Item(String name, short id, String description) {
        this.name = name;
        this.idItem = id;
        this.description = description;
    }

    /**
     * Constructor to create a duplicate item object.
     * All properties of the original item are copied to the new item.
     * @param item
     */
    public Item(Item item) {
        this.name = item.getName();
        this.idItem = item.getID();
        this.description = item.toString();
    }

    /**
     * Private method to generate a unique id for an item.
     * @return Math.random
     */
    private short getNewID() {
        return (short)(Math.random() * 1000);
    }

    /**
     * Get the name of the item.
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the identification of the item.
     * @return
     */
    public short getID() {
        return this.idItem;
    }

    public abstract void use();

    /**
     * Get the description of the item.
     */
    public String toString() {
        return this.description;
    }
}