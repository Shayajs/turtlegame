package com.items.unwieldy;

import com.items.Item;
import com.items.type.UselessItem;

/**
 * This item is usely placed for location
 */
public class Door extends Item implements UselessItem {
    public Door(Item item) {
        super(item);
    }

    public Door(String name) {
        super(name);
    }

    public Door(String name, short id) {
        super(name, id);
    }

    public Door(String name, String description) {
        super(name, description);
    }

    public Door(String name, short id, String description) {
        super(name, id, description);
    }

    @Override
    public void use() {
        throw new UnsupportedOperationException("'use' can't be used on Door Items.");
    }
}