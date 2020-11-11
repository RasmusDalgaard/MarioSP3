package Domain;

import Domain.Pizza;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Order {
    private String orderId;
    private String phoneNr;
    private String dTimeStamp;
    private String cTimeStamp;
    private List<Pizza> pizzas;
    DateFormat dateFormat = new SimpleDateFormat("HH:mm");
    DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    Calendar cal = Calendar.getInstance();
    Calendar cal1 = Calendar.getInstance();

    public Order() {
        UUID uuid = UUID.randomUUID();
        this.dTimeStamp = dateFormat.format(getDeliveryTime());
        this.cTimeStamp = dateFormat1.format(getTime());
        this.pizzas = new ArrayList<>();
        this.orderId = uuid.toString();
    }

    public Date getDeliveryTime() {
        cal.add(Calendar.MINUTE, 10);
        return cal.getTime();
    }

    public Date getTime() {
        return cal1.getTime();
    }

    public String getCTimeStamp() {
        return cTimeStamp;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
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

    public String getAllPizzaTitles() {
        String allPizzaIds = "";
        for (Pizza p : pizzas) {
            allPizzaIds += p.getTitle() + ",";
        }
        int lastCommaIndex = allPizzaIds.lastIndexOf(",");
        allPizzaIds = allPizzaIds.substring(0, lastCommaIndex);

        return allPizzaIds;
    }

    @Override
    public String toString() {
        String pizzaProperties = "";
        for (Pizza p : pizzas) {
            pizzaProperties += p.getTitle() + "\t" + p.getPrice() + ",-" + "\n";
        }

        return pizzaProperties +
                "Total price: " + getPrice() + ",-" + "\n" +
                "Phone number: " + phoneNr + "\n" +
                "Estimated ready: " + dTimeStamp;

    }
}
