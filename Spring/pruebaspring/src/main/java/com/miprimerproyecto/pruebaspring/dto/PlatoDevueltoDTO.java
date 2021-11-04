package com.miprimerproyecto.pruebaspring.dto;

import com.miprimerproyecto.pruebaspring.model.Ingrediente;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class PlatoDevueltoDTO {

    private String namePlato;
    private List<Ingrediente> ingredientes;
    private int caloriastotal;
    private String ingredienteConMasCalorias;

}
