package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Ingredient;
import mk.ukim.finki.wp.lab.repository.JPAinterfaces.JPAIngredientsRepository;
import mk.ukim.finki.wp.lab.service.IngredientsService;

public class IngredientServiceImpls implements IngredientsService {
    private final JPAIngredientsRepository JPAIngredientsRepository;

    public IngredientServiceImpls(JPAIngredientsRepository JPAIngredientsRepository) {
        this.JPAIngredientsRepository = JPAIngredientsRepository;
    }

    @Override
    public void addIngredient(Ingredient ingredient) {

    }

    @Override
    public void deleteIngredient(Ingredient ingredient) {

    }

    @Override
    public void editIngredient(Ingredient ingredient) {

    }

    @Override
    public Ingredient getIngredientByID(String name) {
        return null;
    }
}
