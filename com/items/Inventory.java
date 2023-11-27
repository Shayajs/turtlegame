package com.items;

import java.util.ArrayList;
import java.util.Map;
import com.items.type.*;

/**
 * This class Inventory can be implemented to a Hero, a map (Locations) or a NPC
 */
public class Inventory {
    // Create a dictionary of item that will list the number of item that there is in an inventory under the form <key, value> = <Items, Integer>
    // ex : inventory.put(Items("Couteau"), 2) -> We add two knives in the inventories
    Map<Item, Integer> inventory;

    public Inventory() {
        this.inventory = new java.util.HashMap<>(); // Instance of the dictionary
    }

    /**
     * Put a new item in inventory or increment by 1 if already put
     * @param item
     */
    public void addItem(Item item) throws RawItemNotAllowedException {
        if(item.getClass() == Item.class)
        throw new RawItemNotAllowedException();

        if(this.isOnInventory(item)) {
            this.inventory.put(item, this.inventory.get(item) + 1 ); // Add 1 if object already exists
        }
        else {
            this.inventory.put(item, 1); // If no object of this type, we put it to 1
        }
    }

    /**
     * Check if an item exists on the inventory
     * @param item
     * @return
     */
    public boolean isOnInventory(Item item) {
        return this.inventory.containsKey(item);
    }

    /**
     * Check if an item exists on the inventory with the id
     * @param id
     * @return
     */
    public boolean isOnInventory(short id) {
        for (Item i: this.inventory.keySet()) {
            if (i.getID() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if an item exists on the inventory with a name
     * @param name
     * @return
     */
    public boolean isOnInventory(String name) {
        for (Item i: this.inventory.keySet()) {
            if (i.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get a item from inventory with id
     * @param id
     * @return
     */
    private Item getItem(short id) {
        for (Item i : this.inventory.keySet()) {
            if (i.getID() == id) {
                return i;
            }
        }
        return null;
    }

    /**
     * Get a item from inventory with name
     * @param name
     * @return
     */
    private Item getItem(String name) {
        for (Item i : this.inventory.keySet()) {
            if (i.getName() == name) {
                return i;
            }
        }
        return null;
    }

    /**
     * Delete an item within the inventory
     * @param item
     */
    private void removeFromInventory(Item item) {
        if (this.inventory.containsKey(item)) {
            this.inventory.remove(item);
        }
    }

    /**
     * Check if an item exists and pick one
     * @param id
     * @return item
     */
    public Item pickItem(short id) {
        if(this.isOnInventory(id)) {
            Item itemWanted = this.getItem(id); // We retrieve the item before making any manipulation on the inventory
            int numberOfItem = this.inventory.get(itemWanted); // We retrieve its number for better reading the code

            if(numberOfItem > 1) {
                this.inventory.put(itemWanted, numberOfItem - 1);
                return itemWanted;
            }
            else if(numberOfItem == 1) {
                this.removeFromInventory(itemWanted);
                return itemWanted;
            }
        }
        return null;
    }

    /**
     * Check if an item exists and pick one
     * @param name
     * @return item
     */
    public Item pickItem(String name) {
        if(this.isOnInventory(name)) {
            Item itemWanted = this.getItem(name); // We retrieve the item before making any manipulation on the inventory
            int numberOfItem = this.inventory.get(itemWanted); // We retrieve its number for better reading the code

            if(numberOfItem > 1) {
                this.inventory.put(itemWanted, numberOfItem - 1);
                return itemWanted;
            }
            else if(numberOfItem == 1) {
                this.removeFromInventory(itemWanted);
                return itemWanted;
            }
        }
        return null;
    }

    public void printListToolItem() {
        for(Item item : this.inventory.keySet()) {
            if(item instanceof ToolItem) {
                System.out.print(item.getName() + " - ");
            }
        }
        System.out.println();
    }

    public void printListUselessItem() {
        for(Item item : this.inventory.keySet()) {
            if(item instanceof UselessItem) {
                System.out.print(item.getName() + " - ");
            }
        }
        System.out.println();
    }

    public ArrayList<Short> getIdListToolItem() {
        ArrayList<Short> idList = new ArrayList<>();
        for(Item item : this.inventory.keySet()) {
            if(item instanceof ToolItem) {
                idList.add(item.getID());
            }
        }
        return idList;
    }

    public ArrayList<Short> getIdListUselessItem() {
        ArrayList<Short> idList = new ArrayList<>();
        for(Item item : this.inventory.keySet()) {
            if(item instanceof UselessItem) {
                idList.add(item.getID());
            }
        }
        return idList;
    }
}
//
//This code provides a basic implementation of an inventory system. It allows you to add items, check if an item exists, and pick an item from the inventory.