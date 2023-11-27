package com.items.unwieldy;

import com.items.Item;
import com.items.type.UselessItem;

/**
 * This item is usely placed for location
 */
public class Shelf extends Item implements UselessItem, Unwieldy {
    public Shelf(Item item) {
        super(item);
    }

    public Shelf(String name) {
        super(name);
    }

    public Shelf(String name, short id) {
        super(name, id);
    }

    public Shelf(String name, String description) {
        super(name, description);
    }

    public Shelf(String name, short id, String description) {
        super(name, id, description);
    }

    @Override
    public void use() {
        throw new UnsupportedOperationException("'use' can't be used on Storage Shelf Items.");
    }
}