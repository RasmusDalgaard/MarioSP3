import java.util.Scanner;

public class Menu implements IMenu {
    Scanner sc = new Scanner(System.in);

    public void showMainMenu() {
        System.out.println("1) Show Pizza Menu");
        System.out.println("2) Create order");
        System.out.println("9) Exit");
    }

    public void showSubMenu() {
        System.out.println("\n4) Go Back");
    }

    public int showOrderInstruction() {
        int retVal = 0;
        System.out.println("\nType the number of the Pizza you wish to add the order");
        retVal = sc.nextInt();
        return retVal;
    }

}
