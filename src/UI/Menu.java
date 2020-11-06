package UI;

import UI.IMenu;

import java.util.Scanner;

public class Menu implements IMenu {
    Scanner sc = new Scanner(System.in);

    public void showMainMenu() {
        System.out.println("1) Show Menu");
        System.out.println("2) Create order");
        System.out.println("3) Show active orders");
        System.out.println("9) Exit");
    }

    public int addPizzaToOrder() {
        int retVal = 0;
        System.out.println("\nEnter pizza ID");
        retVal = sc.nextInt();
        System.out.println("99) Confirm order");
        return retVal;
    }

    public int addPhoneNrToOrder() {
        int phoneNr = 0;
        System.out.println("Enter phoneNr: ");
        phoneNr = sc.nextInt();
        return phoneNr;
    }
}
