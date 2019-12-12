package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

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
    private String name;

    private Boolean spicy;

    private Float amount;

    private Boolean veggie;

}
