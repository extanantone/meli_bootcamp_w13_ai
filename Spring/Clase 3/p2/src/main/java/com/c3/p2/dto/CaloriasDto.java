package com.c3.p2.dto;

import com.c3.p2.model.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CaloriasDto {
    Double totalCalorias;
    List<Ingrediente> ingredientes;
    Ingrediente ingredienteMasCalorico;
}
