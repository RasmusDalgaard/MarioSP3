package UI;

import Exceptions.InvalidPhoneNumberException;
import Exceptions.NoSuchPizzaException;
import UI.IMenu;

import java.util.Scanner;

public class Menu implements IMenu {
    Scanner sc = new Scanner(System.in);

    public void showMainMenu() {
        System.out.println("1) Show Menu");
        System.out.println("2) Create order");
        System.out.println("3) Show active orders");
        System.out.println("4) Confirm order");
        System.out.println("5) Show statistics");
        System.out.println("9) Exit");
    }

    public void exit() {
        System.out.println("Exiting ..");
    }

    public int addPizzaToOrder() throws NoSuchPizzaException{
        int retVal = 0;
        System.out.println("\nEnter pizza ID (99 to exit)");
        retVal = sc.nextInt();
        if (retVal>11 && retVal != 99) {
            throw new NoSuchPizzaException();
        }
        return retVal;
    }

    public String addPhoneNrToOrder() throws InvalidPhoneNumberException {
        String phoneNr = "";
        System.out.println("Enter phone number: ");
        phoneNr = sc.nextLine();
        if (phoneNr.length() != 8) {
            throw new InvalidPhoneNumberException();
        }
            return phoneNr;
    }

    public void showConfirmOrderUI() {
        System.out.println("Order saved\n");
    }

    public void newLine() {
        System.out.println("\n");
    }
}
