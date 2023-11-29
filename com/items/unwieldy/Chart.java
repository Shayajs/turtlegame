package com.items.unwieldy;

import com.items.Item;
import com.items.type.UselessItem;

/**
 * This item is usely placed for location
 */
public class Chart extends Item implements UselessItem, Unwieldy {
    public Chart(Item item) {
        super(item);
    }

    public Chart(String name) {
        super(name);
    }

    public Chart(String name, short id) {
        super(name, id);
    }

    public Chart(String name, String description) {
        super(name, description);
    }

    public Chart(String name, short id, String description) {
        super(name, id, description);
    }

    @Override
    public void use() {
        throw new UnsupportedOperationException("'use' can't be used on Bed Items.");
    }
}