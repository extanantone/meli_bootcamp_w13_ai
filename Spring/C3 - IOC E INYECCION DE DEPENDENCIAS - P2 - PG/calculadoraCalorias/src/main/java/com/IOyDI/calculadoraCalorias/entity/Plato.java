package com.IOyDI.calculadoraCalorias.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Plato {
    private String nombre;
    private Map<String, Double> ingredientes;
}
