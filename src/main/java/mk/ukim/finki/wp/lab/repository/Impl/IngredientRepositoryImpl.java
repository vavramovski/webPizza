package mk.ukim.finki.wp.lab.repository.Impl;

import mk.ukim.finki.wp.lab.model.Exceptions.IngredientsLimitExceededException;
import mk.ukim.finki.wp.lab.model.Exceptions.InvalidIngredientException;
import mk.ukim.finki.wp.lab.model.Ingredient;
import mk.ukim.finki.wp.lab.model.Pizza;
import mk.ukim.finki.wp.lab.repository.IngredientsRepository;
import mk.ukim.finki.wp.lab.repository.JPAinterfaces.JPAIngredientsRepository;
import mk.ukim.finki.wp.lab.repository.JPAinterfaces.JPAPizzaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientRepositoryImpl implements IngredientsRepository {
    private final JPAIngredientsRepository ingredientsRepository;
    private final JPAPizzaRepository pizzaRepository;

    public IngredientRepositoryImpl(JPAIngredientsRepository ingredientsRepository, JPAPizzaRepository pizzaRepository) {
        this.ingredientsRepository = ingredientsRepository;
        this.pizzaRepository = pizzaRepository;
    }

    @Override
    public Ingredient addIngredient(Ingredient ingredient) {
        if (ingredientsRepository.findById(ingredient.getName()).isPresent())
            throw new InvalidIngredientException();

        if (getCount()>7)
            throw new IngredientsLimitExceededException();

        ingredientsRepository.save(ingredient);
        return ingredient;
    }

    @Override
    public void deleteIngredient(Ingredient ingredient) {
        List<Pizza>pizzas=pizzaRepository.findAll();
        for (Pizza p:pizzas) {
            p.getIngredients().remove(ingredient);
        }
        ingredientsRepository.delete(ingredient);
    }

    @Override
    public void deleteIngredientByID(String id) {
        Ingredient ingr = getIngredientByID(id).orElseThrow(InvalidIngredientException::new);
        deleteIngredient(ingr);
    }

    @Override
    public Ingredient editIngredient(Ingredient newIngredient, String IDoldIngredient) {
        ingredientsRepository.deleteById(IDoldIngredient);
        ingredientsRepository.save(newIngredient);
        return newIngredient;
    }

    @Override
    public Optional<Ingredient> getIngredientByID(String name) {
        return ingredientsRepository.findById(name);
    }


    public List<Ingredient> getSpicyIngredients() {
        return ingredientsRepository.findBySpicyTrue();
    }

    public List<Ingredient> getNOTSpicyIngredients() {
        return ingredientsRepository.findBySpicyFalse();
    }

    public long getCount(){
        return ingredientsRepository.count();
    }

    //todo:might fail

    public List<Pizza> findPizzasByIngredient(String id) {
        List<Pizza> pizzas = new LinkedList<>();
        Ingredient ingr = getIngredientByID(id).orElseThrow(InvalidIngredientException::new);
        for (Pizza p :pizzaRepository.findAll()) {
            if (p.getIngredients().contains(ingr))
                pizzas.add(p);
        }
        return pizzas;
    }


    public Page<Ingredient> getPage(Integer pagenum, Integer size) {
        return ingredientsRepository.findAll(PageRequest.of(pagenum, size, Sort.by("name").ascending()));
    }
}

