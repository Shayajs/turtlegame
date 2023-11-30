package com.items.wieldy.tool;

import com.items.Item;
import com.items.type.ToolItem;
import com.items.wieldy.Wieldy;
import com.utils.TurtleFunction;

public class Paper extends Item implements ToolItem, Wieldy {
    public Paper(Item item) {
        super(item);
    }

    public Paper(String name) {
        super(name);
    }

    public Paper(String name, short id) {
        super(name, id);
    }

    public Paper(String name, String description) {
        super(name, description);
    }

    public Paper(String name, short id, String description) {
        super(name, id, description);
    }

    @Override
    public void use() {
        try {
            TurtleFunction.print("You use the paper");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
