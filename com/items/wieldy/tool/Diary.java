package com.items.wieldy.tool;

import com.items.Item;
import com.items.type.ToolItem;
import com.items.wieldy.Wieldy;

public class Diary extends Item implements ToolItem, Wieldy {
    public Diary(Item item) {
        super(item);
    }

    public Diary(String name) {
        super(name);
    }

    public Diary(String name, short id) {
        super(name, id);
    }

    public Diary(String name, String description) {
        super(name, description);
    }

    public Diary(String name, short id, String description) {
        super(name, id, description);
    }

    @Override
    public void use() {
        throw new UnsupportedOperationException("Unimplemented method 'use'");
    }
}
