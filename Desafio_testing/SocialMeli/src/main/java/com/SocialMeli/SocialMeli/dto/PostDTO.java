package com.SocialMeli.SocialMeli.dto;


import com.SocialMeli.SocialMeli.model.Post;
import com.SocialMeli.SocialMeli.model.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PostDTO {
    @NotNull(message = "El ID no puede estar vacío.")
    @Positive(message = "El ID debe ser mayor a cero.")
    private int user_id;

    @NotNull(message = "El ID Post no puede estar vacío.")
    @Positive(message = "El ID Post debe ser mayor a cero.")
    private int id_post;

    @NotNull(message = "La fecha no puede estar vacía.")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;

    @Valid
    private ProductDTO detail;

    @Positive(message = "El campo no puede estar vacío.")
    private int category;

    @NotNull(message = "El campo no puede estar vacío.")
    @DecimalMax(value = "10000000", message = "El precio máximo por producto es de 10.000.000.")
    private double price;
}
