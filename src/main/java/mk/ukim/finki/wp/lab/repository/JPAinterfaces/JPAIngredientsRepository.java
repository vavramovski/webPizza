package mk.ukim.finki.wp.lab.repository.JPAinterfaces;

import mk.ukim.finki.wp.lab.model.Ingredient;
import mk.ukim.finki.wp.lab.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JPAIngredientsRepository extends JpaRepository<Ingredient,String> {

        List<Ingredient> findBySpicyTrue();

        List<Ingredient> findBySpicyFalse();

}
