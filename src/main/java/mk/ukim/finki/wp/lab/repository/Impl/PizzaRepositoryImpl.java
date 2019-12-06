package mk.ukim.finki.wp.lab.repository.Impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.lab.model.Pizza;
import mk.ukim.finki.wp.lab.repository.JPAinterfaces.JPAPizzaRepository;
import mk.ukim.finki.wp.lab.repository.PizzaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class PizzaRepositoryImpl implements PizzaRepository {
    JPAPizzaRepository pizzaRepository;



    public List<Pizza> getAllPizzas(){
       return pizzaRepository.findAll();
    }

    @Override
    public void addPizza(Pizza pizza) {
        pizzaRepository.save(pizza);
    }
}
