package mk.ukim.finki.wp.lab;

import mk.ukim.finki.wp.lab.model.Ingredient;
import mk.ukim.finki.wp.lab.model.Pizza;
import mk.ukim.finki.wp.lab.repository.Impl.IngredientRepositoryImpl;
import mk.ukim.finki.wp.lab.repository.Impl.PizzaRepositoryImpl;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

@Component
public class DATAHOLDER {
    private final PizzaRepositoryImpl pizzaRepository;
    private final IngredientRepositoryImpl ingredientRepository;

    public DATAHOLDER(PizzaRepositoryImpl pizzaRepository, IngredientRepositoryImpl ingredientRepository) {
        this.pizzaRepository = pizzaRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @PostConstruct
    void init() {

        List<Ingredient> ingredients = new LinkedList<>();
        ingredients.add(new Ingredient("Pecurka", false, (float)100, true));
        ingredients.add(new Ingredient("Magdonos", false, (float)100, true));
        ingredients.add(new Ingredient("Peperoni", true, (float)150, false));
        ingredients.add(new Ingredient("Domat", false, (float)50, true));

        for (Ingredient ingredient : ingredients) {
            ingredientRepository.addIngredient(ingredient);
        }

        List<Pizza> pizzas = new LinkedList<>();
        pizzas.add(new Pizza("Margarita", "(tomato sauce, mozzarella)", ingredients.subList(0,2), true));
        pizzas.add(new Pizza("Carbonara", "(fresh cream, mozzarella, bacon)", ingredients.subList(1,2), true));
        pizzas.add(new Pizza("Vegetariana", "(tomato sauce, mushrooms)", ingredients.subList(0,3), true));
        pizzas.add(new Pizza("Calzone", "(Pizza dough, ricotta, pepperoni, pizza sauce, olive oil)",ingredients.subList(0,2), false));
        pizzas.add(new Pizza("Cheddar", "(Taleggio, Mascarpone, Gorgonzola, Parmesan)", ingredients.subList(1,3), false));
        pizzas.add(new Pizza("Capricciosa", "(cheddar, tomato sauce)", ingredients.subList(0,2), true));
        pizzas.add(new Pizza("Burger Classic", "(tomato sauce, cheese, ham)", ingredients.subList(1,3), true));
        pizzas.add(new Pizza("Burger Barbecue", "(barbecue sauce, beef, mozzarella, onions)", ingredients.subList(0,1), false));
        pizzas.add(new Pizza("Pepperoni", "(ham, chicken meat, onions)", ingredients.subList(0,2), false));
        pizzas.add(new Pizza("Quattro Formaggi", "(tomato sauce, mozzarella, sausage)", ingredients.subList(0,3), true));

        for (Pizza p : pizzas) {
            pizzaRepository.addPizza(p);
        }




    }
}

