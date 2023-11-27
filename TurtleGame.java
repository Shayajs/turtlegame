import com.items.*;
import com.items.wieldy.tool.Paper;
import com.items.wieldy.weapon.*;
import com.utils.TurtleFunction;

public class TurtleGame {
    public static void main(String[] argv) throws RawItemNotAllowedException, InterruptedException {

        Item knife = new Knife("Couteau");
        Item sword = new Sword("Epée");
        Item paper = new Paper("Papier 1");
        Inventory bag = new Inventory();
        bag.addItem(sword);
        bag.addItem(knife);
        bag.addItem(paper);

        bag.printListWeaponItem();
        bag.printListToolItem();

        TurtleFunction.printConversation(paper.getDescription());
    }
}