package com.example.socialMeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
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
    @PastOrPresent
    private LocalDate fecha;
    private Producto detalle;
    private int categoria;
    private double precio;
    private boolean promo;
    private double descuento;

}
