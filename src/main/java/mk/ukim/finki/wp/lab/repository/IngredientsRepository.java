package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Ingredient;

import java.util.Optional;

public interface IngredientsRepository {
    Ingredient addIngredient(Ingredient ingredient);

    void deleteIngredient(Ingredient ingredient);

    void deleteIngredientByID(String id);

    Ingredient editIngredient(Ingredient ingredient, String IDoldIngredient);

    Optional<Ingredient> getIngredientByID(String name);
}
