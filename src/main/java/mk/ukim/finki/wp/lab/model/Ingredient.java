package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.RowId;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PersistenceUnits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Ingredients")
@Max(value = 3)
public class Ingredient {

    @Id
    @Column(unique = true, name = "ingredient_name")
    private String name;

    private Boolean spicy;

    private Float amount;

    private Boolean veggie;

}
