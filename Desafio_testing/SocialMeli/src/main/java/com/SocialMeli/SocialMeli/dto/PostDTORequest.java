package com.SocialMeli.SocialMeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter @Setter
public class PostDTORequest {
    @NotNull(message = "La id no puede estar vacia")
    @Positive(message = "El id debe ser mayor a cero")
    protected Integer user_id;

    @NotNull(message = "La id no puede estar vacia")
    @Positive(message = "El id debe ser mayor a cero")
    protected Integer id_post;

    @NotNull(message = "La fecha no puede estar vacia")
    @JsonFormat(pattern = "dd-MM-yyyy")
    protected LocalDate date;

    @NotNull(message = "Debe incluir el detalle de un producto")
    @Valid
    protected ProductDTO detail;

    @NotNull(message = "El campo no puede estar vacio")
    protected Integer category;

    //@Pattern(regexp = "(\\d{1,3}(?:[.,]\\d{3})*(?:[,]\\d{2}))\\s?", message = "El precio debe estar separado por puntos para los miles y coma para los decimales")
    @NotNull(message = "El campo no puede estar vacio")
    @Max(value = 10000000, message = "El precio maximo de producto es 10.000.000")
    protected Double price;

}
