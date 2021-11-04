package ruiz_facundo.CalcuCaloRias.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class InfoPlatoDTO implements Serializable {
    double totalCalories;
    HashMap<String, Double> caloriesByIngredient;
    String mostCaloricIngredient;

    public InfoPlatoDTO() {}
}
