package com.bootcamp.CalCalorias.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InfoPlato extends Plato{

    private Integer TotalCalorias;
    private Ingredientes MayorCaloria;

    public InfoPlato(Plato plato) {
        this.setIngredientes(plato.getIngredientes());
        this.setNombre(plato.getNombre());
    }
}
