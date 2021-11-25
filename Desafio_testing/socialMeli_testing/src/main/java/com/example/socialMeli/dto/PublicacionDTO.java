package com.example.socialMeli.dto;

import com.example.socialMeli.model.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PublicacionDTO implements Serializable {

    @Positive(message = "EL id del usuario debe ser un número mayor a 0")
    @NotNull (message = "Debe introducir un id para el usuario")
    private Integer user_id;
    @NotNull(message = "Debe introducir un id para el post")
    @Positive(message = "EL id del post debe ser un número mayor a 0")
    private Integer id_post;
    @NotNull(message = "Debe introducir una fecha")
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])[- \\.](0[1-9]|1[012])[- \\.](19|20)\\d\\d$", message = "La fecha debe tener formato dd-mm-yyyy")
    private String date;
    private ProductoDTO detail;
    private int category;
    @NotNull(message = "Debe introducir un precio")
    @Min(value = 0, message = "El precio no puede ser menor a 0")
    @Max(value = 10000000, message = "El precio no puede superar los 10.000.000")
    private Double price;
    private boolean has_promo;
    private double discount;


}
