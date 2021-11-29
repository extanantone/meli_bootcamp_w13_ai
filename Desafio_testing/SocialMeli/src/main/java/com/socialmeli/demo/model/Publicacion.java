package com.socialmeli.demo.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
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
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Publicacion {
    private Integer id_user;
    private Integer id_publicacion;
    private LocalDate fecha;
    private Producto detalle;
    private Integer categoria;
    private Integer precio;
    private boolean promo;
    private double descuento;


}
