package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Ingredient;
import mk.ukim.finki.wp.lab.model.Pizza;
import mk.ukim.finki.wp.lab.repository.Impl.IngredientRepositoryImpl;
import mk.ukim.finki.wp.lab.service.IngredientsService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpls implements IngredientsService {
    private final IngredientRepositoryImpl ingredientsRepository;

    public IngredientServiceImpls(IngredientRepositoryImpl ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    @Override
    public Ingredient addIngredient(Ingredient ingredient) {
        return ingredientsRepository.addIngredient(ingredient);
    }

    @Override
    public void deleteIngredient(Ingredient ingredient) {
        ingredientsRepository.deleteIngredient(ingredient);
    }

    @Override
    public void deleteIngredientByID(String id) {
        ingredientsRepository.deleteIngredientByID(id);
    }

    @Override
    public Ingredient editIngredient(Ingredient ingredient, String idName) {
        ingredientsRepository.deleteIngredientByID(idName);
        return ingredientsRepository.addIngredient(ingredient);
    }

    @Override
    public Optional<Ingredient> getIngredientByID(String name) {
        return ingredientsRepository.getIngredientByID(name);
    }

    /////////////// DOPOLNITELNI

    public List<Ingredient> getSpicyIngredients() {
        return ingredientsRepository.getSpicyIngredients();
    }

    public List<Ingredient> getNOTSpicyIngredients() {
        return ingredientsRepository.getNOTSpicyIngredients();
    }

    @Override
    public long getCountIngredients() {
        return ingredientsRepository.getCount();
    }

    public List<Pizza> findPizzasByIngredient(String id) {
        return ingredientsRepository.findPizzasByIngredient(id);
    }

    public Page<Ingredient> getPages(Integer pagenum, Integer size) {
        return ingredientsRepository.getPage(pagenum, size);
    }
}
