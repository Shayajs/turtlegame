package com.items.unwieldy;

import com.items.Item;
import com.items.type.UselessItem;

/**
 * This item is usely placed for location
 */
public class Bench extends Item implements UselessItem {
    public Bench(Item item) {
        super(item);
    }

    public Bench(String name) {
        super(name);
    }

    public Bench(String name, short id) {
        super(name, id);
    }

    public Bench(String name, String description) {
        super(name, description);
    }

    public Bench(String name, short id, String description) {
        super(name, id, description);
    }

    @Override
    public void use() {
        throw new UnsupportedOperationException("'use' can't be used on Bench Items.");
    }
}