package com.example.socialMeli.dto;

import com.example.socialMeli.model.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PublicacionDTO {
    @NotNull(message = "Debe introducir un user id")
    private int user_id;
    @NotNull(message = "Debe introducir un id para el post")
    private int id_post;
    @NotNull(message = "Debe introducir una fecha")
    private String date;
    private ProductoDTO detail;
    @NotNull(message = "Debe introducir una categoría")
    private int category;
    @NotNull(message = "Debe introducir un precio")
    @Min(value = 0, message = "El precio no puede ser menor a 0")
    private double price;
    private boolean has_promo;
    private double discount;


}
