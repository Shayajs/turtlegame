package com.items.unwieldy;

import com.items.Item;
import com.items.type.UselessItem;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'use'");
    }
}
