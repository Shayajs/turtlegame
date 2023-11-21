package com.items.wieldy.weapon;

import com.items.Item;
import com.items.type.WeaponItem;

public class Sword extends Item implements WeaponItem {

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
        throw new UnsupportedOperationException("Unimplemented method 'use'");
    }

    @Override
    public int getDamage() {
        throw new UnsupportedOperationException("Unimplemented method 'getDamage'");
    }
    
}
