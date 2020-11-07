package Services;

import Domain.Order;
import Domain.Pizza;

import java.util.ArrayList;

public interface IOrderService {
    public void createOrder();
    public void showActiveOrders();
    public ArrayList<Order> getOrders();
}
