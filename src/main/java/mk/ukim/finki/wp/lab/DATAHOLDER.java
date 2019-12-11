package mk.ukim.finki.wp.lab;

import mk.ukim.finki.wp.lab.model.Ingredient;
import mk.ukim.finki.wp.lab.model.Pizza;
import mk.ukim.finki.wp.lab.repository.PizzaRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

@Component
public class DATAHOLDER {
    private final PizzaRepository pizzaRepository;

    public DATAHOLDER(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @PostConstruct
    void init() {
        List<Pizza> pizzas=new LinkedList<>();
     pizzas.add(new Pizza("Margarita", "(tomato sauce, mozzarella)", new LinkedList<>(), true));
     pizzas.add(new Pizza("Carbonara ","(fresh cream, mozzarella, bacon)", new LinkedList<>(), true));
     pizzas.add(new Pizza("Vegetariana ","(tomato sauce, mushrooms)", new LinkedList<>(), true));
     pizzas.add(new Pizza("Calzone ","(Pizza dough, ricotta, pepperoni, pizza sauce, olive oil)", new LinkedList<>(), false));
     pizzas.add(new Pizza("Cheddar ", "(Taleggio, Mascarpone, Gorgonzola, Parmesan)", new LinkedList<>(), false));
     pizzas.add(new Pizza("Capricciosa ","(cheddar, tomato sauce)", new LinkedList<>(), true));
     pizzas.add(new Pizza("Burger Classic ","(tomato sauce, cheese, ham)", new LinkedList<>(), true));
     pizzas.add(new Pizza("Burger Barbecue","(barbecue sauce, beef, mozzarella, onions)", new LinkedList<>(), false));
     pizzas.add(new Pizza("Pepperoni ","(ham, chicken meat, onions)", new LinkedList<>(), false));
     pizzas.add(new Pizza("Quattro Formaggi", "(tomato sauce, mozzarella, sausage)", new LinkedList<>(), true));

        for (Pizza p :pizzas) {
            pizzaRepository.addPizza(p);
        }

    }
}
