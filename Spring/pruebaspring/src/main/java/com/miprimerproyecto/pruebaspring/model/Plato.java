package com.miprimerproyecto.pruebaspring.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Plato {

    private String name;
    private List<Ingrediente> ingredientes;
}
