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
        boolean hasHog = babou.getInventory().isOnInventory("Hoglet");
        if(Command.getCurrentLocation().getName().equalsIgnoreCase("forest") && hasHog) {
            try {
                TurtleFunction.print("\nYou brought back Hoglet to his family !\n Now, since DinoLou explained you how to go, you unlocked SecretVillage");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Map<String, Exit> exits = Command.getCurrentLocation().getExit();
            Exit e = exits.get("F2V");
            if(e != null)
            e.unlock();
            else
            System.err.println("Error with unlock");
            babou.getInventory().removeFromInventory(this);
        }
    }
}
