package com.test;

import com.items.Inventory;
import com.items.Item;
import com.items.RawItemNotAllowedException;
import com.items.wieldy.tool.Diary;
public class InventoryTest {
    Inventory inv;
    Item item;
    short id;
    public InventoryTest() throws RawItemNotAllowedException {
        inv = new Inventory();
        item = new Diary("Test");

        //Test
        addItemsTest();
        getIDTest();
        isOnInventoryTest();
        pickItemTest();
        printListToolItemTest();
        printListUselessItemTest();
        isPickableTest();
        getDescriptionOfTest();
        getListItemTest();

    }
    // Testing adding items to inventory
    public void addItemsTest() throws RawItemNotAllowedException{
        System.out.println("\nAdd Items test: ");
        inv.addItem(item);
    }

    public void isOnInventoryTest() {
        System.out.println("\nIs on inventory test: ");
        if (inv.isOnInventory(item)) {
            System.out.print("The diary is in the inventory.");
        } else {
            System.out.print("The diary is not in the inventory.");
        }
    }

    public void getIDTest() {
        id = item.getID();
    }

    public void pickItemTest() {
        System.out.println("\nPick up an item from inventory test: ");
        item = inv.pickItem(id);
    }

    public void printListToolItemTest() {
        System.out.println("\nPrint list of tools and wieldable items test: ");
        inv.printListToolItem();
    }

    public void printListUselessItemTest() {
        System.out.println("\nPrint list of useless items test: ");
        inv.printListUselessItem();
    }

    public void getListItemTest() {
        System.out.println("\nGet a specific item by ID test: ");
        inv.getListItem();
    }

    public void getDescriptionOfTest() {
        System.out.println("\nGet description of an item by its name test: ");
        String desc = inv.getDescriptionOf(item.getName());
        System.out.println(desc);
    }

    public void isPickableTest() {
        System.out.println("\nCheck if an item can be picked up test: ");
        boolean b = inv.isPickable(item.getName());
        if (b) {
            System.out.println("Yes, it's possible to pick this item up");
        } else {
            System.out.println("No, you cannot pick this item up");
        }
    }

    public void useItemTest() {
        System.out.println("\nUse an item test: ");
        inv.useItem(item.getName());
    }
}
