package Services;

import Domain.Pizza;
import Exceptions.NoSuchPizzaException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PizzaService implements IPizzaService {
    public List<Pizza> getAllPizzas() {
        List<Pizza> pizzas = new ArrayList<>();
        File file = new File("resources/pizzas.txt");
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] lineArr = line.split(",", 4);
                Pizza pizza = new Pizza(Integer.parseInt(lineArr[0]), Integer.parseInt(lineArr[1]), lineArr[2], lineArr[3]);
                pizzas.add(pizza);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pizzas;
    }

    public void showPizzaMenu() {
        for (Pizza p : getAllPizzas()) {
            System.out.println(p);
        }
    }

    public Pizza getPizzaById(int id) throws NoSuchPizzaException {
        for (Pizza p : getAllPizzas()) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
