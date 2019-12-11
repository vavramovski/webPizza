package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Ingredient;

import java.util.Optional;

public interface IngredientsService {

    Ingredient addIngredient(Ingredient ingredient);

    void deleteIngredient(Ingredient ingredient);

    Ingredient editIngredient(Ingredient ingredient, String idName);

    Optional<Ingredient> getIngredientByID(String name);

    void deleteIngredientByID(String id);

    long getCountIngredients();
}
