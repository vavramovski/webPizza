package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Ingredient;

public interface IngredientsService {

    void addIngredient(Ingredient ingredient);

    void deleteIngredient(Ingredient ingredient);

    void editIngredient(Ingredient ingredient);

    Ingredient getIngredientByID(String name);
}
