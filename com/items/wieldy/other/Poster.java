package com.items.wieldy.other;

import com.items.Item;
import com.items.type.UselessItem;

public class Poster extends Item implements UselessItem{
    public Poster(Item item) {
        super(item);
    }

    public Poster(String name) {
        super(name);
    }

    public Poster(String name, short id) {
        super(name, id);
    }

    public Poster(String name, String description) {
        super(name, description);
    }

    public Poster(String name, short id, String description) {
        super(name, id, description);
    }

    @Override
    public void use() {
        throw new UnsupportedOperationException("Unimplemented method 'use'");
    }
}

