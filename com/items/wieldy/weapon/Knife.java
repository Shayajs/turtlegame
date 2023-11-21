package com.items.wieldy.weapon;

import com.items.Item;
import com.items.type.WeaponItem;

public class Knife extends Item implements WeaponItem {
    public Knife(Item item) {
        super(item);
    }

    public Knife(String name) {
        super(name);
    }

    public Knife(String name, short id) {
        super(name, id);
    }

    public Knife(String name, String description) {
        super(name, description);
    }

    public Knife(String name, short id, String description) {
        super(name, id, description);
    }

    @Override
    public void use() {
        throw new UnsupportedOperationException("Unimplemented method 'use'");
    }

    @Override
    public int getDamage() {
        throw new UnsupportedOperationException("Unimplemented method 'getDamage'");
    }
}
