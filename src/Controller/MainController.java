package Controller;

import Domain.Order;
import Domain.Pizza;
import Services.*;
import UI.Menu;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class MainController {
    Scanner sc = new Scanner(System.in);
    IPizzaService ps = new PizzaService();
    IOrderService os = new OrderService();
    IOrdersFileService ofs = new OrdersFileService();
    IStatisticsService ss = new StatisticsService();
    Menu menu = new Menu();
    int choice = 0;

    public void runProgram() {
        while (choice != 9) {
            menu.showMainMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    ps.showPizzaMenu();
                    menu.newLine();
                    break;
                case 2:
                    os.createOrder();
                    break;
                case 3:
                    os.showActiveOrders();
                    menu.newLine();
                    break;
                case 4:
                    ofs.writeToFile(os.getOrders());
                    os.clearOrders();
                    menu.showConfirmOrderUI();
                    break;
                case 5:
                    ss.showStatistics();
                    menu.newLine();
                    break;
                case 9:
                    menu.exit();
                    break;
                default:
                    menu.exit();
                    break;
            }
        }
    }
}
