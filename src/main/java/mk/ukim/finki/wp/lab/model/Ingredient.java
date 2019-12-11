package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;

//@Max(value = 3)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Ingredients")
public class Ingredient {

    @Id
    @Column(unique = true, name = "ingredient_name")
    private String name;

    private Boolean spicy;

    private Float amount;

    private Boolean veggie;

}
