package com.test;
import static com.utils.TurtleFunction.*;

import java.io.IOException;

public class TurtleFunctionTest {
    public TurtleFunctionTest() throws IOException, InterruptedException {
        getConversationNPC("com/test/test_text/test_paper");
        getDescriptionFile("com/test/test_text/test_attack1");
        print("Text test");        
    }
}
