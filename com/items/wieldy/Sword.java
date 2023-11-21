package com.items.wieldy;

import com.items.Item;

public class Sword extends Item {

    public Sword(Item item) {
        super(item);
    }

    public Sword(String name) {
        super(name);
    }

    public Sword(String name, short id) {
        super(name, id);
    }

    public Sword(String name, String description) {
        super(name, description);
    }

    public Sword(String name, short id, String description) {
        super(name, id, description);
    }

    @Override
    public void use() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'use'");
    }
    
}
