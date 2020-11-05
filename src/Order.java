import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    static int counter = 0;
    int orderId;
    int phoneNr;
    LocalDateTime timeStamp;
    List<Pizza> pizzas;
    String status;

    public Order(   ) {
        this.orderId = counter;
        this.timeStamp = LocalDateTime.now();
        this.pizzas = new ArrayList<>();
        this.status = "Created";

        counter++;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getPhoneNr() {
        return phoneNr;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public String getStatus() {
        return status;
    }

    public void setPhoneNr(int phoneNr) {
        this.phoneNr = phoneNr;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addPizza(Pizza pizza) {
        this.pizzas.add(pizza);
    }

    public int getPrice() {
        int price = 0;
        for (Pizza pizza : pizzas) {
            price += pizza.getPrice();
        }
        return price;
    }
}
