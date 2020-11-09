package Services;

import Domain.Pizza;
import Exceptions.NoSuchPizzaException;

import java.util.List;

public interface IPizzaService {
    public List<Pizza> getAllPizzas();

    public void showPizzaMenu();
    public Pizza getPizzaById(int id) throws NoSuchPizzaException;
}
