package menu;


/**
 *
 * @author NGUYENPHI
 */
import java.util.ArrayList;
import java.util.Scanner;
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
        for (int i = 0; i < options.length; i++) {
            System.out.println(i + "-" + options[i]);
        }
        System.out.println("==================================================");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        return choice;
    }
}