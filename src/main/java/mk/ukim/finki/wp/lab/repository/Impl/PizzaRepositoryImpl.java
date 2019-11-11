package mk.ukim.finki.wp.lab.repository.Impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.lab.model.Pizza;
import mk.ukim.finki.wp.lab.repository.PizzaRepository;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
@AllArgsConstructor
public class PizzaRepositoryImpl implements PizzaRepository {
    private List<Pizza> pizzas;

    public List<Pizza> getAllPizzas(){
        pizzas = new LinkedList<Pizza>();
        pizzas.add(new Pizza("Margherita", "(tomato sauce, mozzarella)"));
        pizzas.add(new Pizza("Carbonara ","(fresh cream, mozzarella, bacon)"));
        pizzas.add(new Pizza("Vegetariana ","(tomato sauce, mushrooms)"));
        pizzas.add(new Pizza("Calzone ","(Pizza dough, ricotta, pepperoni, pizza sauce, olive oil)"));
        pizzas.add(new Pizza("Cheddar ", "(Taleggio, Mascarpone, Gorgonzola, Parmesan)"));
        pizzas.add(new Pizza("Capricciosa ","(cheddar, tomato sauce)"));
        pizzas.add(new Pizza("Burger Classic ","(tomato sauce, cheese, ham)"));
        pizzas.add(new Pizza("Burger Barbecue","(barbecue sauce, beef, mozzarella, onions)"));
        pizzas.add(new Pizza("Pepperoni ","(ham, chicken meat, onions)"));
        pizzas.add(new Pizza("Quattro Formaggi", "(tomato sauce, mozzarella, sausage)"));
        return pizzas;
    }
}
