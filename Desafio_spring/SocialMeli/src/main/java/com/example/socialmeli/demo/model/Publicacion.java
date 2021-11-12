package com.example.socialmeli.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Publicacion {

    private int id;
    private LocalDate fechaPublicacion;
    private String descripcion;
    private Long likes;
    private Long vendedorID;


}
