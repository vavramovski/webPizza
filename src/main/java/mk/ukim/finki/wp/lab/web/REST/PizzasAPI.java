package mk.ukim.finki.wp.lab.web.REST;

import mk.ukim.finki.wp.lab.model.Exceptions.InvalidIngredientException;
import mk.ukim.finki.wp.lab.model.Exceptions.PizzaNotFoundException;
import mk.ukim.finki.wp.lab.model.Ingredient;
import mk.ukim.finki.wp.lab.model.Pizza;
import mk.ukim.finki.wp.lab.repository.PizzaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pizzas")
public class PizzasAPI {
    private final PizzaRepository pizzaRepository;

    public PizzasAPI(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @PostMapping
    public Pizza addPizza(@RequestBody Pizza pizza) {
        if (pizza.getVeggie() == null)
            pizza.setVeggie(false);

        if (pizza.getVeggie())
            for (Ingredient ing : pizza.getIngredients())
                if (!ing.getVeggie())
                    throw new InvalidIngredientException();

        return pizzaRepository.addPizza(pizza);
    }

    @PutMapping("/{id}")
    public Pizza editPizza(@RequestBody Pizza pizza, @PathVariable String id) {
        return pizzaRepository.editPizza(pizza, id);
    }

    @PostMapping("/{id}")
    public void deletePizza(@PathVariable String id) {
        pizzaRepository.deletePizza(id);
    }

    //todo: ne moze na istiot path
    @GetMapping("lessThan")
    public List<Pizza> lessThan(@RequestParam Integer totalIngredients) {
        return pizzaRepository.getPizzasWithLessThan(totalIngredients);
    }

    @GetMapping()
    public List<Pizza> getPizzas() {
        return pizzaRepository.getAllPizzas();
    }

    @GetMapping("/{id}")
    public Pizza getPizza(@PathVariable String id) throws PizzaNotFoundException {
        return pizzaRepository.getPizzaByID(id);
    }

    @GetMapping("compare")
    public List<Ingredient> lessThan(@RequestParam String pizza1, @RequestParam String pizza2) throws PizzaNotFoundException {
        return pizzaRepository.comparePizzas(pizza1, pizza2);
    }


}
