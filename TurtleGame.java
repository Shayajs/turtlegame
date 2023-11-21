import com.utils.Command;
import com.items.*;
import com.items.wieldy.*;

public class TurtleGame {
    public static void main(String[] argv) throws RawItemNotAllowedException {
        Command.help();
        Item couteau = new Knife("Couteau");
        Item sword = new Sword("Epée");
        
        Inventory bag = new Inventory();
        bag.putItems(sword);
        bag.putItems(couteau);

        System.out.println();
    }
}