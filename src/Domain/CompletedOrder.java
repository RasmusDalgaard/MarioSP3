package Domain;

import Services.IPizzaService;
import Services.IStatisticsService;
import Services.PizzaService;
import Services.StatisticsService;

import java.util.ArrayList;
import java.util.List;

public class CompletedOrder {
    private String timestamp;
    private String id;
    private String phoneNr;
    private List<String> pizzas;
    private int price;
    IPizzaService ps = new PizzaService();
    IStatisticsService ss = new StatisticsService();

    public CompletedOrder(String timestamp, String id, String phoneNr, List<String> pizzas, String price) {
        this.timestamp = timestamp;
        this.id = id;
        this.phoneNr = phoneNr;
        this.pizzas = pizzas;
        this.price = Integer.parseInt(price);
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public List<String> getPizzas() {
        return pizzas;
    }

    public void setPizzas(ArrayList<String> pizzas) {
        this.pizzas = pizzas;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
