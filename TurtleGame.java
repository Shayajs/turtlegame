import java.io.IOException;

import com.items.RawItemNotAllowedException;
import com.test.Unitest;
import com.utils.ProjetInit;

public class TurtleGame {
    public static void main(String[] argv) throws RawItemNotAllowedException, InterruptedException, IOException {
        System.out.println("TURTLE GAME");
        if(argv.length >= 1) {
            System.out.println("Mode debug");
            if(argv[0].equalsIgnoreCase("debug")) 
            {
                new Unitest();
            }
        } else {
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
}