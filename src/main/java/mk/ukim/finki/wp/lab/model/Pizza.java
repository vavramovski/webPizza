package mk.ukim.finki.wp.lab.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pizza {
    private String name;
    private String description;

    @Override
    public String toString() {
        return name+"  "+description;
    }
}
