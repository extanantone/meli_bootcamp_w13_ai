package com.bootcamp.calculadora_de_calorias.dto;

import com.bootcamp.calculadora_de_calorias.model.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InfoCaloriasDTO {

    private String nombre;
    private Double cantTotalCalorias;
    private List<Ingrediente> ingredientes;
    private String ingredienteConMasCalorias;

}
