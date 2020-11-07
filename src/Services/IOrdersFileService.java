package Services;

import Domain.Order;

import java.util.ArrayList;

public interface IOrdersFileService {
    public void writeToFile(ArrayList<Order> orders);
}
