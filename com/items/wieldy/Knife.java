package com.items.wieldy;

import com.items.Item;

public class Knife extends Item {
    public Knife(Item item) {
        super(item);
    }

    public Knife(String name) {
        super(name);
    }

    public Knife(String name, short id) {
        super(name, id);
    }

    public Knife(String name, String description) {
        super(name, description);
    }

    public Knife(String name, short id, String description) {
        super(name, id, description);
    }

    @Override
    public void use() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'use'");
    }
}
