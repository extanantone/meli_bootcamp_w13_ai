package ruiz_facundo.CalcuCaloRias.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ingrediente {
    String name;
    Integer calories;

    public Ingrediente() {}

    public Ingrediente(String inName, Integer inCalories) {
        this.calories = inCalories;
        this.name = inName;
    }
}
