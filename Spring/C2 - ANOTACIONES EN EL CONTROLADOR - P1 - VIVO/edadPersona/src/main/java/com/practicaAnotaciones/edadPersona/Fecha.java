package com.practicaAnotaciones.edadPersona;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Fecha {
    private String dia;
    private String mes;
    private String anio;
}
