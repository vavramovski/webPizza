package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Exceptions.PizzaNotFoundException;
import mk.ukim.finki.wp.lab.model.Pizza;

import java.util.List;

public interface PizzaService {
    List<Pizza> getPizzas();

    Pizza editPizza(Pizza newPizza, String idOld);

    Pizza addPizza(Pizza pizza);

    void deletePizza(String id);

    Pizza getPizaaByID(String id) throws PizzaNotFoundException;

    boolean isVeggie();


}
