package com.items.unwieldy;

import com.items.Item;
import com.items.type.UselessItem;

/**
 * This item is usely placed for location
 */
public class Grass extends Item implements UselessItem {
    public Grass(Item item) {
        super(item);
    }

    public Grass(String name) {
        super(name);
    }

    public Grass(String name, short id) {
        super(name, id);
    }

    public Grass(String name, String description) {
        super(name, description);
    }

    public Grass(String name, short id, String description) {
        super(name, id, description);
    }

    @Override
    public void use() {
        throw new UnsupportedOperationException("'use' can't be used on Grass Items.");
    }
}
