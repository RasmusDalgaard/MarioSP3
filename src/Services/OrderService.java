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
    List<Order> orders = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    Menu menu = new Menu();
    IPizzaService ps = new PizzaService();

    public void createOrder() {
        Order order = new Order();
        IMenu iMenu = new Menu();
        int choice = 0;
        int pizzaId = 0;
        List<Pizza> allPizzas = ps.getAllPizzas();
        while (pizzaId != 99) {
            pizzaId = iMenu.addPizzaToOrder();
            Pizza pizza = null;
            pizza = allPizzas.get(pizzaId);
            allPizzas.add(pizza);
            orders.add(order);
            if(pizzaId != 99) {
                pizzaId = choice;
            }
        }
    }


    public void showActiveOrders() {
        for (Order orders : orders) {
            System.out.println(orders);
        }
    }

    public Pizza getPizzaFromId(int id) {

        return pizzas.get(id);

    }
}
