package com.items.unwieldy;

import com.items.Item;
import com.items.type.UselessItem;

/**
 * This item is usely placed for location
 */
public class StorageShelf extends Item implements UselessItem {
    public StorageShelf(Item item) {
        super(item);
    }

    public StorageShelf(String name) {
        super(name);
    }

    public StorageShelf(String name, short id) {
        super(name, id);
    }

    public StorageShelf(String name, String description) {
        super(name, description);
    }

    public StorageShelf(String name, short id, String description) {
        super(name, id, description);
    }

    @Override
    public void use() {
        throw new UnsupportedOperationException("'use' can't be used on Storage Shelf Items.");
    }
}