package com.items;

import java.lang.Math;

public class Items {

    private String name;
    private short idItem;
    private String description;

    /**
     * "Items" is an object
     * @param name
     */
    public Items(String name) {
        this.name = name;
        this.idItem = this.getNewID();
    }

    public Items(String name, String description) {
        this.name = name;
        this.description = description;
        this.idItem = this.getNewID();
    }

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
