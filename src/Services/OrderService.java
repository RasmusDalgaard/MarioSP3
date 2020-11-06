package Services;

import Domain.Order;
import Domain.Pizza;
import Services.IOrderService;
import Services.IPizzaService;
import UI.IMenu;
import UI.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService implements IOrderService {
    List<Pizza> pizzas = new ArrayList<>();
    Order order;
    Scanner sc = new Scanner(System.in);
    Menu menu = new Menu();
    IPizzaService ps = new PizzaService();

    public void createOrder() {
        order = new Order();
        IMenu iMenu = new Menu();
        int pizzaId = 0;
        int phoneNr = 0;
        phoneNr = iMenu.addPhoneNrToOrder();
        order.setPhoneNr(phoneNr);
        List<Pizza> allPizzas = ps.getAllPizzas();
        while (pizzaId != 99) {
            pizzaId = iMenu.addPizzaToOrder();
            if (pizzaId != 99) {
                Pizza pizza = null;
                pizza = ps.getPizzaById(pizzaId);
                order.getPizzas().add(pizza);
            }
        }
    }

    public void showActiveOrders() {
        System.out.println(order);
    }

}
