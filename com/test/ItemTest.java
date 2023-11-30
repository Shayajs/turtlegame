package com.test;
import java.io.IOException;

import com.items.Item;
import com.items.wieldy.tool.Paper;
public class ItemTest {
    public Item paper;

    public ItemTest() throws IOException {
        paper = new Paper("Paper Test");
        getNameTest();
        getDescriptionTest();
        getIDTest();
        setDescriptionFileTest();
        setDescriptionTest();
        useTest();
    }

    public void getNameTest() {
        System.out.println(paper.getName());
    }

    public void getIDTest() {
        System.out.println(paper.getID());
    }

    public void setDescriptionTest() {
        String description = "This is a test of the emergency broadcast system.";
        paper.setDescription(description);
    }

    public void getDescriptionTest() {
        System.out.println(paper.getDescription());
    }

    public void setDescriptionFileTest() throws IOException {
        String filePath = "com/test/test_text/test_paper";
        paper.setDescriptionFile(filePath);
    }

    public void useTest() {
        paper.use();
    }
}
