package com.items.unwieldy;

import com.items.Item;
import com.items.type.UselessItem;

/**
 * This item is usely placed for location
 */
public class Desk extends Item implements UselessItem {
    public Desk(Item item) {
        super(item);
    }

    public Desk(String name) {
        super(name);
    }

    public Desk(String name, short id) {
        super(name, id);
    }

    public Desk(String name, String description) {
        super(name, description);
    }

    public Desk(String name, short id, String description) {
        super(name, id, description);
    }

    @Override
    public void use() {
        throw new UnsupportedOperationException("'use' can't be used on Bed Items.");
    }
}