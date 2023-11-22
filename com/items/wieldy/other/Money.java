package com.items.wieldy.other;

import com.items.Item;
import com.items.type.UselessItem;

public class Money extends Item implements UselessItem{
    public Money(Item item) {
        super(item);
    }

    public Money(String name) {
        super(name);
    }

    public Money(String name, short id) {
        super(name, id);
    }

    public Money(String name, String description) {
        super(name, description);
    }

    public Money(String name, short id, String description) {
        super(name, id, description);
    }

    @Override
    public void use() {
        throw new UnsupportedOperationException("Unimplemented method 'use'");
    }
}