package mk.ukim.finki.wp.lab.repository.JPAinterfaces;

import mk.ukim.finki.wp.lab.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAIngredientsRepository extends JpaRepository<Ingredient,String> {


}
