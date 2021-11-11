package com.example.socialMeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    private int id_producto;
    private String nombre_producto;
    private String tipo;
    private String marca;
    private String color;
    private String notas;


}
