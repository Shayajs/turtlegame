package com.items.wieldy; 

import com.items.Item;
import com.items.type.UselessItem;

public class Stone extends Item implements UselessItem{
    public Stone(Item item) {
        super(item);
    }

    public Stone(String name) {
        super(name);
    }

    public Stone(String name, short id) {
        super(name, id);
    }

    public Stone(String name, String description) {
        super(name, description);
    }

    public Stone(String name, short id, String description) {
        super(name, id, description);
    }

    @Override
    public void use() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'use'");
    }
}
