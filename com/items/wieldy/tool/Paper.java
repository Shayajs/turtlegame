package com.items.wieldy.tool;

import com.items.Item;
import com.items.type.ToolItem;

public class Paper extends Item implements ToolItem {
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
        throw new UnsupportedOperationException("Unimplemented method 'use'");
    }
}
