package com.items.unwieldy;

import com.items.Item;
import com.items.type.UselessItem;

/**
 * This item is usely placed for location
 */
public class Branch extends Item implements UselessItem {
    public Branch(Item item) {
        super(item);
    }

    public Branch(String name) {
        super(name);
    }

    public Branch(String name, short id) {
        super(name, id);
    }

    public Branch(String name, String description) {
        super(name, description);
    }

    public Branch(String name, short id, String description) {
        super(name, id, description);
    }

    @Override
    public void use() {
        throw new UnsupportedOperationException("'use' can't be used on Grass Items.");
    }
}

