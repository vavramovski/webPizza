package mk.ukim.finki.wp.lab.repository.JPAinterfaces;

import mk.ukim.finki.wp.lab.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JPAPizzaRepository extends JpaRepository<Pizza,String> {

    List<Pizza> findPizzaByIngredients(String ingredient);
}
