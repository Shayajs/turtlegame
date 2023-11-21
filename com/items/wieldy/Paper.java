package com.items.wieldy;

import com.items.Item;

public class Paper extends Item {
    public Paper(Item item) {
        super(item);
    }

    public Paper(String name) {
        super(name);
    }

    public Paper(String name, short id) {
        super(name, id);
    }

    public Paper(String name, String description) {
        super(name, description);
    }

    public Paper(String name, short id, String description) {
        super(name, id, description);
    }

    @Override
    public void use() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'use'");
    }
}
