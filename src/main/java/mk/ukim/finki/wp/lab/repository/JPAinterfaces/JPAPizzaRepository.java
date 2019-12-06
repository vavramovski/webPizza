package mk.ukim.finki.wp.lab.repository.JPAinterfaces;

import mk.ukim.finki.wp.lab.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAPizzaRepository extends JpaRepository<Pizza,String> {
}
