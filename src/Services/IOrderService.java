package Services;

import Domain.Pizza;

public interface IOrderService {
    public void createOrder();
    public void showActiveOrders();
    public Pizza getPizzaFromId(int id);
}