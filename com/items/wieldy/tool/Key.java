package com.items.wieldy.tool;

import com.items.Item;
import com.items.type.ToolItem;

public class Key extends Item implements ToolItem {
    public Key(Item item) {
        super(item);
    }

    public Key(String name) {
        super(name);
    }

    public Key(String name, short id) {
        super(name, id);
    }

    public Key(String name, String description) {
        super(name, description);
    }

    public Key(String name, short id, String description) {
        super(name, id, description);
    }

    @Override
    public void use() {
        throw new UnsupportedOperationException("Unimplemented method 'use'");
    }
}
