package Services;

import Domain.Order;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StatisticsService implements IStatisticsService {

    public List getAllOrders() {
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

    public void showStatistics() {
        for (Order o : getAllOrders()) {
            System.out.println(o);
        }
    }


}
