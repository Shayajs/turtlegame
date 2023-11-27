package com.items.wieldy.other;

import com.items.Item;
import com.items.type.UselessItem;
import com.items.wieldy.Wieldy;

public class FamilyPortrait extends Item implements UselessItem, Wieldy{
    public FamilyPortrait(Item item) {
        super(item);
    }

    public FamilyPortrait(String name) {
        super(name);
    }

    public FamilyPortrait(String name, short id) {
        super(name, id);
    }

    public FamilyPortrait(String name, String description) {
        super(name, description);
    }

    public FamilyPortrait(String name, short id, String description) {
        super(name, id, description);
    }

    @Override
    public void use() {
        throw new UnsupportedOperationException("Unimplemented method 'use'");
    }
}