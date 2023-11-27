package com.items.wieldy.other; 

import com.items.Item;
import com.items.type.UselessItem;
import com.items.wieldy.Wieldy;

public class Stone extends Item implements UselessItem, Wieldy{
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
        throw new UnsupportedOperationException("Unimplemented method 'use'");
    }
}
