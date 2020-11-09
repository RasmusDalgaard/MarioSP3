package Services;

import Domain.Order;
import Domain.Pizza;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StatisticsService implements IStatisticsService {
    IPizzaService ps = new PizzaService();
    List<Pizza> pizzas = ps.getAllPizzas();

    public List<Order> getAllOrders() {
        List<Order> completedOrders = new ArrayList<>();
        File file = new File("resources/orders.txt");
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] lineArr = line.split(",", 4);
                Order order = new Order();
                completedOrders.add(order);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return completedOrders;
    }

    public String showStatistics() {
        String pizzaStats = "";
        for (Pizza p : pizzas) {
            pizzaStats += p.getTitle() + "\t";
        }
        return pizzaStats;
    }
}
