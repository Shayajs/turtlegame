package com.items.unwieldy;

import com.items.Item;
import com.items.type.UselessItem;

/**
 * This item is usely placed for location
 */
public class Bed extends Item implements UselessItem, Unwieldy {
    public Bed(Item item) {
        super(item);
    }

    public Bed(String name) {
        super(name);
    }

    public Bed(String name, short id) {
        super(name, id);
    }

    public Bed(String name, String description) {
        super(name, description);
    }

    public Bed(String name, short id, String description) {
        super(name, id, description);
    }

    @Override
    public void use() {
        throw new UnsupportedOperationException("'use' can't be used on Bed Items.");
    }
}