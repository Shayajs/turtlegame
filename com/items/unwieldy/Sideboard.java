package com.items.unwieldy;

import com.items.Item;
import com.items.type.UselessItem;

/**
 * This item is usely placed for location
 */
public class Sideboard extends Item implements UselessItem, Unwieldy {
    public Sideboard(Item item) {
        super(item);
    }

    public Sideboard(String name) {
        super(name);
    }

    public Sideboard(String name, short id) {
        super(name, id);
    }

    public Sideboard(String name, String description) {
        super(name, description);
    }

    public Sideboard(String name, short id, String description) {
        super(name, id, description);
    }

    @Override
    public void use() {
        throw new UnsupportedOperationException("'use' can't be used on Bed Items.");
    }
}