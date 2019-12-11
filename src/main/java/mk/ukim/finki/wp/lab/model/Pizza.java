package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Pizzas")
public class Pizza {
    @Id
    @Column(name = "pizza_name")
    private String name;
    private String description;

    @ManyToMany
    private List<Ingredient> ingredients;
    private Boolean veggie;

    @Override
    public String toString() {
        return name + "  " + description;
    }
}
