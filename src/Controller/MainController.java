package Controller;

import Domain.Pizza;
import Services.IOrderService;
import Services.IPizzaService;
import Services.OrderService;
import Services.PizzaService;
import UI.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    Scanner sc = new Scanner(System.in);
    IPizzaService ps = new PizzaService();
    IOrderService os = new OrderService();
    Menu menu = new Menu();
    List<Pizza> pizzas = new ArrayList<>();
    int choice = 0;

    public void runProgram() {
        while (choice != 9) {
            menu.showMainMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    ps.showPizzaMenu();
                    System.out.println("\n");
                    break;
                case 2:
                    os.createOrder();
                    break;
                case 3:
                    os.showActiveOrders();
                    System.out.println("\n");
                    break;
                default:
                    choice = 9;
                    break;
            }
        }
    }
}