import java.io.IOException;

import com.items.RawItemNotAllowedException;
import com.test.Unitest;
import com.utils.ProjetInit;

public class TurtleGame {
    public static void main(String[] argv) throws RawItemNotAllowedException, InterruptedException, IOException {
        if(argv.length >= 2)
        if(argv[1] == "debug")
        new Unitest();

        /**
         * In there, we init all variable, all locations, all exits, all items
         * And set all the connections between all objects.
         */  
        ProjetInit.init();

        /**
         * After the initialization, this command start the game, and the loop 'while'.
         */
        ProjetInit.start();
    }
}