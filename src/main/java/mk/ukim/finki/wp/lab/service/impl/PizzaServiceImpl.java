package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Exceptions.PizzaNotFoundException;
import mk.ukim.finki.wp.lab.model.Ingredient;
import mk.ukim.finki.wp.lab.model.Pizza;
import mk.ukim.finki.wp.lab.repository.PizzaRepository;
import mk.ukim.finki.wp.lab.service.PizzaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService  {

    private final PizzaRepository pizzaRepository;

    public PizzaServiceImpl(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }


    @Override
    public List<Pizza> getPizzas() {
        return pizzaRepository.getAllPizzas();
    }

    @Override
    public Pizza editPizza(Pizza newPizza, String idOld) {
        return pizzaRepository.editPizza(newPizza, idOld);
    }

    @Override
    public Pizza addPizza(Pizza pizza) {
        for (Ingredient i:pizza.getIngredients())
            if (!i.getVeggie()) {
                pizza.setVeggie(false);
                break;
            }
            
        return pizzaRepository.addPizza(pizza);
    }

    @Override
    public void deletePizza(String id) {
        pizzaRepository.deletePizza(id);
    }

    @Override
    public Pizza getPizaaByID(String id) throws PizzaNotFoundException {
        return pizzaRepository.getPizzaByID(id);
    }

    @Override
    public boolean isVeggie() {
        //todo: isVeggie pizzata
        return true;
    }
}
