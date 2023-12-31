package com.items;

import java.io.IOException;
import java.lang.Math;

import com.utils.TurtleFunction;

/**
 * An item is a descriptor object of all type of item existable.
 * Hero can have items, Location same.
 * 
 * There are 2 types of Item
 * - ToolItem
 * - UselessItem
 * 
 * An item can be Wieldy or unwieldy
 */
public abstract class Item {

    private String name;
    private short idItem;
    private String description;
    protected boolean isWieldy;

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

    /**
     * Set a new description 
     * @param newDescription
     */
    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    /**
     * Get the description of the item.
     * @return
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Set the file to describe the Item
     * @param filename
     * @throws IOException
     */
    public void setDescriptionFile(String filename) throws IOException {
        this.description = TurtleFunction.getDescriptionFile(filename);
    }

    /**This is abstract to a futur usable.*/
    public abstract void use();

    public String toString() {
        return "\"" + this.name + "\" : " +this.description;
    }
}