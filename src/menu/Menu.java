package menu;


/**
 *
 * @author NGUYENPHI
 */
import java.util.ArrayList;
import util.MyTool;
/**
 *
 * @author ADMIN
 */
public class Menu extends ArrayList<String> {

    public Menu() {
        super();
    }

    public static int getUserChoice(String[] options) {
        System.out.println();
        System.out.println("====================>> MENU <<====================");
        for (int i = 1; i <= options.length; i++) {
            System.out.println(i + "-" + options[i-1]);
        }
        System.out.println("==================================================");
        int choice = MyTool.inputInt("     >> Your choice");
        return choice;
    }
}