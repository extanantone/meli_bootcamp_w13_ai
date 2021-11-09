package com.bootcamp.C3P2EJ1.dto;

import com.bootcamp.C3P2EJ1.model.Ingrediente;
import com.bootcamp.C3P2EJ1.model.Plato;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlatoDTO {
    private String nombre;
    private List<Ingrediente> listaIngredientes;

    public PlatoDTO(Plato plato) {
        this.nombre = plato.getNombre();
        this.listaIngredientes = plato.getListaIngredientes();
    }
}
