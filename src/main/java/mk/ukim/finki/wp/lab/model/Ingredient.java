package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

//@Max(value = 3)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Ingredients")
public class Ingredient {

    @Id
    private String name;

    private Boolean spicy;

    private Float amount;

    private Boolean veggie;

    @Override
    public String toString() {
        return name;
    }
}
