package mk.ukim.finki.wp.lab.repository.JPAinterfaces;

import mk.ukim.finki.wp.lab.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JPAPizzaRepository extends JpaRepository<Pizza,String> {

    /*@Query("select p from Pizza p")
    List<Pizza> strings();*/

    //@Query("select p from Pizza p join PizzaIng i on (i.PIZZA_NAME=p.name)")
    List<Pizza> findPizzaByIngredients(@Param("ingredient") String ingredient);
}
