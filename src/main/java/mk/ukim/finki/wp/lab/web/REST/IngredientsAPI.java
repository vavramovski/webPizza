package mk.ukim.finki.wp.lab.web.REST;

import mk.ukim.finki.wp.lab.model.Exceptions.IngredientsLimitExceededException;
import mk.ukim.finki.wp.lab.model.Exceptions.InvalidIngredientException;
import mk.ukim.finki.wp.lab.model.Ingredient;
import mk.ukim.finki.wp.lab.model.Pizza;
import mk.ukim.finki.wp.lab.service.impl.IngredientServiceImpls;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping(path = "/ingredients")
public class IngredientsAPI {
    private final IngredientServiceImpls ingredientsService;

    public IngredientsAPI(IngredientServiceImpls ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredient createIngredient(@RequestParam String name, @RequestParam Boolean spicy,
                                       @RequestParam Float amount, @RequestParam Boolean veggie) {
        try {
            return ingredientsService.addIngredient(new Ingredient(name, spicy, amount, veggie));
        } catch (Exception e) {
            throw new IngredientsLimitExceededException();
        }
    }

    @PatchMapping("/{id}")
    public Ingredient editIngredient(@RequestParam String name, @RequestParam Boolean spicy,
                                     @RequestParam Float amount, @RequestParam Boolean veggie,
                                     @PathVariable String id) {
        try {
            return ingredientsService.editIngredient(new Ingredient(name, spicy, amount, veggie), id);
        } catch (Exception e) {
            throw new IngredientsLimitExceededException();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable String id) {
        ingredientsService.deleteIngredientByID(id);
    }


    //TODO: GET PAGEABLE INGREDIENTS
    @GetMapping("")
    public Page<Ingredient> sortedIngredients(@RequestParam Integer pagenum,@RequestParam Integer size) {
        return ingredientsService.getPages(pagenum, size);
    }

    @GetMapping("spicy")
    public List<Ingredient> getSpicyIngredients(@RequestParam Boolean spicy) {

        if (spicy)
            return ingredientsService.getSpicyIngredients();

        return ingredientsService.getNOTSpicyIngredients();
    }

    @GetMapping("/{id}")
    public Ingredient getIngredient(@PathVariable String id) {
        return ingredientsService.getIngredientByID(id).orElseThrow(InvalidIngredientException::new);
    }

    @GetMapping("/{id}/pizzas")
    public List<Pizza> getPizzasByIngredientUID(@PathVariable String id) {
        //TODO: Ќе ги врати сите пици што ја содржат состојката со id на: GET /ingredients/{id}/pizzas VO PIZZA REPO
        return ingredientsService.findPizzasByIngredient(id);
    }


}
