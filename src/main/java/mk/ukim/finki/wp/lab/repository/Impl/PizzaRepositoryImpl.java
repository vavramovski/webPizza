package mk.ukim.finki.wp.lab.repository.Impl;

import mk.ukim.finki.wp.lab.model.Exceptions.PizzaNotFoundException;
import mk.ukim.finki.wp.lab.model.Ingredient;
import mk.ukim.finki.wp.lab.model.Pizza;
import mk.ukim.finki.wp.lab.repository.JPAinterfaces.JPAPizzaRepository;
import mk.ukim.finki.wp.lab.repository.PizzaRepository;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class PizzaRepositoryImpl implements PizzaRepository {
    private final JPAPizzaRepository pizzaRepository;

    public PizzaRepositoryImpl(JPAPizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<Pizza> getAllPizzas(){
       return pizzaRepository.findAll();
    }

    @Override
    public Pizza addPizza(Pizza pizza) {
        pizzaRepository.save(pizza);
        return pizza;
    }

    @Override
    public Pizza editPizza(Pizza pizza, String id) {
        pizzaRepository.deleteById(id);
        pizzaRepository.save(pizza);
        return pizza;
    }

    @Override
    public void deletePizza(String id) {
         pizzaRepository.deleteById(id);
    }

    @Override
    public Pizza getPizzaByID(String id) throws PizzaNotFoundException{
        return pizzaRepository.findById(id).orElseThrow(PizzaNotFoundException::new);
    }

    @Override
    public List<Pizza> getPizzasWithLessThan(int number) {
        List<Pizza> nova = new LinkedList<>();
        for (Pizza pizza :pizzaRepository.findAll())
            if (pizza.getIngredients().size() < number)
                nova.add(pizza);

        return nova;
    }

    @Override
    public List<Ingredient> comparePizzas(String id1, String id2) throws PizzaNotFoundException {
        Pizza pizza1 = pizzaRepository.findById(id1).orElseThrow(PizzaNotFoundException::new);
        Pizza pizza2 = pizzaRepository.findById(id2).orElseThrow(PizzaNotFoundException::new);
        List<Ingredient> same = new LinkedList<>();
        for (Ingredient ingredient :pizza1.getIngredients()) {
            if (pizza2.getIngredients().contains(ingredient))
                same.add(ingredient);
        }
        return same;
    }
}
