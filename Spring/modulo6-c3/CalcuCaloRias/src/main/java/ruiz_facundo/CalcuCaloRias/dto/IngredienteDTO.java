package ruiz_facundo.CalcuCaloRias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class IngredienteDTO implements Serializable {
    String name;
    Integer weight;

    public IngredienteDTO() {}
}
