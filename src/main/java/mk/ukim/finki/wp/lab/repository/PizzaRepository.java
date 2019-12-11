package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Exceptions.PizzaNotFoundException;
import mk.ukim.finki.wp.lab.model.Ingredient;
import mk.ukim.finki.wp.lab.model.Pizza;

import java.util.List;

public interface PizzaRepository {
    List<Pizza> getAllPizzas();

    Pizza addPizza(Pizza pizza);

    Pizza editPizza(Pizza pizza, String id);

    void deletePizza(String id);

    Pizza getPizzaByID(String id) throws PizzaNotFoundException;

    List<Pizza> getPizzasWithLessThan(int number);

    List<Ingredient> comparePizzas(String id1, String id2) throws PizzaNotFoundException;



}
