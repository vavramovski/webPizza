package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.model.Exceptions.InvalidIngredientException;
import mk.ukim.finki.wp.lab.repository.Impl.IngredientRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("ingr")
public class IngredientsController {

    private final IngredientRepositoryImpl ingredientRepository;

    public IngredientsController(IngredientRepositoryImpl ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping
    public String home() {
        return "ingr.html";
    }

    @GetMapping("/{id}")
    public ModelAndView edit(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("ingr.html");
        modelAndView.addObject("ingredient", ingredientRepository.getIngredientByID(id).orElseThrow(InvalidIngredientException::new));
        return modelAndView;
    }

}
