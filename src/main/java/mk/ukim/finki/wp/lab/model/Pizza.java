package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String name;
    private String description;

    @ManyToMany(mappedBy = "Pizzas_Ingredients")
    private List<Ingredient> ingredients;
    private Boolean veggie;

    @Override
    public String toString() {
        return name + "  " + description;
    }
}
