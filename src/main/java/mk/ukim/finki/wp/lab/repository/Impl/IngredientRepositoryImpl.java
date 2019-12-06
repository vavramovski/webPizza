package mk.ukim.finki.wp.lab.repository.Impl;

import mk.ukim.finki.wp.lab.model.Ingredient;
import mk.ukim.finki.wp.lab.repository.IngredientsRepository;
import mk.ukim.finki.wp.lab.repository.JPAinterfaces.JPAIngredientsRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class IngredientRepositoryImpl implements IngredientsRepository {
    private final JPAIngredientsRepository ingredientsRepository;

    public IngredientRepositoryImpl(JPAIngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    @Override
    public void addIngredient(Ingredient ingredient) {
        ingredientsRepository.save(ingredient);
    }

    @Override
    public void deleteIngredient(Ingredient ingredient) {
        ingredientsRepository.delete(ingredient);
    }

    @Override
    public void editIngredient(Ingredient newIngredient, String IDoldIngredient) {
        ingredientsRepository.deleteById(IDoldIngredient);
        ingredientsRepository.save(newIngredient);
    }

    @Override
    public Optional<Ingredient> getIngredientByID(String name) {
        return ingredientsRepository.findById(name);
    }
}
