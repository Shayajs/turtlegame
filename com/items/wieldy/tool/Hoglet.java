package com.items.wieldy.tool;

import java.util.Map;

import com.characters.Hero;
import com.items.Item;
import com.items.type.ToolItem;
import com.items.wieldy.Wieldy;
import com.utils.Command;
import com.utils.TurtleFunction;
import com.world.Exit;

public class Hoglet extends Item implements ToolItem, Wieldy {
    public Hoglet(Item item) {
        super(item);
    }

    public Hoglet(String name) {
        super(name);
    }

    public Hoglet(String name, short id) {
        super(name, id);
    }

    public Hoglet(String name, String description) {
        super(name, description);
    }

    public Hoglet(String name, short id, String description) {
        super(name, id, description);
    }

    @Override
    public void use() {
        Hero babou = Command.getHero();
        boolean hasKey = babou.getInventory().isOnInventory("Key");
        if(Command.getCurrentLocation().getName().equalsIgnoreCase("ruinedHouse") && hasKey) {
            try {
                TurtleFunction.print("You used the Key !\n");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Map<String, Exit> exits = Command.getCurrentLocation().getExit();
            Exit e = exits.get("H2S");
            if(e != null)
            e.unlock();
            else
            System.err.println("Error with unlock");
        }
    }
}
