import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    Scanner sc = new Scanner(System.in);
    IPizzaService ps = new PizzaService();
    Menu menu = new Menu();
    List<Pizza> pizzas = new ArrayList<>();
    int choice = 0;

    public void runProgram() {
        menu.showMenu();
        while (choice != 9) {
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    ps.showPizzaMenu();
                    break;
                case 9:
                    exit();
                    break;
                default:
                    choice = 9;
                    break;
            }
        }
    }

    private void exit() {
        choice = 9;
    }
}
