package Services;


import Domain.Order;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OrdersFileService implements IOrdersFileService {
    public void writeToFile(ArrayList<Order> orders) {
        File file = new File("resources/orders.txt");
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Order order : orders) {
                String msg = String.format("%s;%s;%s;%s;%d", order.getCTimeStamp(), order.getOrderId(), order.getPhoneNr(), order.getAllPizzaTitles(), order.getPrice());
                bw.write(msg);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
