import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService implements IOrderService {
    private final List<Pizza> pizzas = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    Menu menu = new Menu();

    public void createOrder() {

    }

    public Pizza getPizzaFromId(int id) {

        return pizzas.get(id);

    }
}
