package com.items.unwieldy;

import com.items.Item;
import com.items.type.UselessItem;

/**
 * This item is usely placed for location
 */
public class TheRock extends Item implements UselessItem {
    public TheRock(Item item) {
        super(item);
    }

    public TheRock(String name) {
        super(name);
    }

    public TheRock(String name, short id) {
        super(name, id);
    }

    public TheRock(String name, String description) {
        super(name, description);
    }

    public TheRock(String name, short id, String description) {
        super(name, id, description);
    }

    @Override
    public void use() {
        throw new UnsupportedOperationException("Unimplemented method 'use'");
    }
}
