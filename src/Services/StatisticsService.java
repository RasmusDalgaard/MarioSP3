package Services;

import Domain.CompletedOrder;
import Domain.Pizza;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class StatisticsService implements IStatisticsService {
    IPizzaService ps = new PizzaService();
    HashMap<String, Integer> pizzaFrequency = new HashMap<String, Integer>();

    public List<CompletedOrder> getAllOrders() {
        List<CompletedOrder> completedOrders = new ArrayList<>();
        File file = new File("resources/orders.txt");
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] lineArr = line.split(";", 5);
                String timestamp = lineArr[0];
                String id = lineArr[1];
                String phoneNr = lineArr[2];
                String[] p = lineArr[3].split(",");
                List<String> pizzas = new ArrayList<>();
                pizzas = Arrays.asList(p);
                String price = lineArr[4];

                CompletedOrder order = new CompletedOrder(timestamp, id, phoneNr, pizzas, price);
                completedOrders.add(order);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return completedOrders;
    }

    public void showStatistics() {
        ArrayList<String> pizzaCount = new ArrayList<>();
        List<CompletedOrder> completedOrders = getAllOrders();
        for (CompletedOrder o : completedOrders) {
            for (String p : o.getPizzas()) {
                pizzaCount.add(p);
            }
        }
        for (Pizza p : ps.getAllPizzas()) {
            pizzaFrequency.put(p.getTitle(), getPizzaFrequency(p.getTitle(), pizzaCount));
            System.out.println(p.getTitle() + ": " + getPizzaFrequency(p.getTitle(), pizzaCount));
        }
        System.out.println("\nTotal earned: " + getTurnover() + ",-");
    }

    public int getTurnover() {
        int price = 0;
        for (CompletedOrder o : getAllOrders()) {
            price += o.getPrice();
        }
        return price;
    }

    public int getPizzaFrequency(String target, ArrayList<String> pizzas) {
        int counter = 0;
        for (String p : pizzas) {
            if (p.equals(target)) {
                counter = counter + 1;
            }
        }
        return counter;
    }

}
