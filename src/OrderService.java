import java.rmi.NoSuchObjectException;
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
        List<Pizza> allPizzas = ps.getAllPizzas();
        int pizzaId = iMenu.showOrderInstruction();
        Pizza pizza = null;
        pizza = allPizzas.get(pizzaId);
        allPizzas.add(pizza);
        orders.add(order);

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
