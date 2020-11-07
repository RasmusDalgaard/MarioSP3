package Domain;

import Domain.Pizza;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Order {
    static int counter = 0;
    int orderId;
    int phoneNr;
    String dTimeStamp;
    String cTimeStamp;
    List<Pizza> pizzas;
    String status;
    DateFormat dateFormat = new SimpleDateFormat("HH:mm");
    Calendar cal = Calendar.getInstance();


    public Order() {
        this.orderId = counter;
        this.dTimeStamp = dateFormat.format(getDeliveryTime());
        this.dTimeStamp = dateFormat.format(getTime());
        this.pizzas = new ArrayList<>();
        this.status = "Created";
        counter++;
    }

    public Date getDeliveryTime() {
        cal.add(Calendar.MINUTE, 10);
        return cal.getTime();
    }

    public Date getTime() {
        return cal.getTime();
    }

    public int getOrderId() {
        return orderId;
    }

    public int getPhoneNr() {
        return phoneNr;
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

    public String getAllPizzaTitles() {
        String allPizzaIds = "";
        for (Pizza p : pizzas) {
            allPizzaIds += p.getTitle() + ", ";
        }

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
                "Order received: " + getTime() + "\n" +
                "Estimated delivery: " + dTimeStamp;

    }
}
