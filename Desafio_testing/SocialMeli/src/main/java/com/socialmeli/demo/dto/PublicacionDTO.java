package com.socialmeli.demo.dto;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublicacionDTO {


    @Positive(message = "EL id del usuario debe ser un número mayor a 0")
    @NotNull(message = "El id del usuario no puede ser nulo")

    private Integer user_id;

    @NotNull(message = "El id del post no puede ser nulo")
    @Positive(message = "EL id del post debe ser un número mayor a 0")
    private Integer id_post;

    @NotEmpty(message = "La fecha no puede ser nula")
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])[- \\.](0[1-9]|1[012])[- \\.](19|20)\\d\\d$", message = "E formato de la fecha es dd-mm-yyyy")
    private String date;
    @Valid
    private ProductoDTO detail;
    private Integer category;

    @NotNull(message = "El precio no puede ser nulo")
    @Min(value = 0, message = "El precio debe ser mayor a cero")
    @Max(value = 10000000, message = "El precio no puede superar los 10000000")
    private Integer price;
    private boolean has_promo;
    private double discount;







}
