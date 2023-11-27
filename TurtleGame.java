import com.items.*;
import com.items.wieldy.tool.Paper;
import com.items.wieldy.weapon.*;

public class TurtleGame {
    public static void main(String[] argv) throws RawItemNotAllowedException {

        Item knife = new Knife("Couteau");
        Item sword = new Sword("Epée");
        Item paper = new Paper("Papier 1");
        Inventory bag = new Inventory();
        bag.addItem(sword);
        bag.addItem(knife);
        bag.addItem(paper);

        bag.printListWeaponItem();
        bag.printListToolItem();

        System.out.println(bag.getIdListWeaponItem());
    }
}