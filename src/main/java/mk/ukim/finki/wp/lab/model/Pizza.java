package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    @ManyToMany(targetEntity = Ingredient.class)
    @Column(name = "PizzaIng")
    private List<Ingredient> ingredients;
    private Boolean veggie;



    @Override
    public String toString() {
        String str="";
        for (Ingredient i : ingredients) {
            str+=i.toString()+" ";
        }
        return name + "  " + str;
    }
}
