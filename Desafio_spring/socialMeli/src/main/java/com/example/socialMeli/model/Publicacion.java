package com.example.socialMeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Publicacion {
    private int id_user;
    private int id_publicacion;
    private LocalDate fecha;
    private List<Producto> detalle;
    private int categoria;
    private double precio;

    public Publicacion(int id_user, LocalDate fecha, int categoria, double precio) {
        this.id_user = id_user;
        this.fecha = fecha;
        this.detalle = new ArrayList<Producto>();
        this.categoria = categoria;
        this.precio = precio;
    }
}
