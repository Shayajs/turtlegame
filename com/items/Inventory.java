package com.items;

import java.util.Map;

/**
 * This class Inventory can be implented to a Hero, a map (Locations) or a NPC
 */
public class Inventory {
    // Crée un dictionnaire d'item qui va lister le nombre d'élément qu'il y a dans un inventaire sous la forme <clef, valeur> = <Items, Integer>
    // ex : inventory.put(Items("Couteau"), 2) -> On ajoute deux couteaux dans l'inventaires
    Map<Item, Integer> inventory;

    public Inventory() {
        this.inventory = new java.util.HashMap<>(); //Instance du disctionnaire
    }

    /**
     * Put a new item in inventory or increment by 1 if already put 
     * @param item
     */
    public void putItems(Item item) {
        if(this.isOnInventory(item)) {
            this.inventory.put(item, this.inventory.get(item) + 1 ); //Ajoute 1 si objet existe déjà
        }
        else {
            this.inventory.put(item, 1); //Si pas d'objet de ce type on le met à 1
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
     */
    public Item pickItem(short id) {
        if(this.isOnInventory(id)) {
            Item itemWanted = this.getItem(id); // On récupère l'item avant de faire des manipulation sur l'inventaire
            int numberOfItem = this.inventory.get(itemWanted); // On récupère son nombre pour mieux lire le code

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

    public Item pickItem(String name) {
        if(this.isOnInventory(name)) {
            Item itemWanted = this.getItem(name); // On récupère l'item avant de faire des manipulation sur l'inventaire
            int numberOfItem = this.inventory.get(itemWanted); // On récupère son nombre pour mieux lire le code

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
}