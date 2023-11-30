package com.test;

import com.characters.Hero;
import com.items.Inventory;

public class HeroTest {
    public HeroTest() {
        Hero saviour = new Hero("testHero", new Inventory());
        saviour.getName();
    }
}
