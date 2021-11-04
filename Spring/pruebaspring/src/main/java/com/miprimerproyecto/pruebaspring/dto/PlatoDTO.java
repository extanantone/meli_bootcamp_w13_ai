package com.miprimerproyecto.pruebaspring.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class PlatoDTO {

    private String name;
    private List<IngredientesDTO> ingredientesDTOS;

}
