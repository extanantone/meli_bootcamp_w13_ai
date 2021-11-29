package com.example.SocialMeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
//@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")

public class PublicationDto {

    @Positive(message = "El id debe ser mayor a cero")
    @NotNull(message = "El id debe ser mayor a cero")
    private int userId;
    @Positive(message = "El id debe ser mayor a cero")
    @NotNull(message = "El id debe ser mayor a cero")
    private int idPost;

    @NotNull(message = "La fecha no puede estar vacía.")
    @NotEmpty(message = "La fecha no puede estar vacía.")
    private String date;

    @Valid
    private ProductDto detail;

    @NotNull(message = "El campo no puede estar vacio")
    private int category;

    @NotNull(message = "El id debe ser mayor a cero")
    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
    private double price;

    //atributos para publicación con descuento
    private boolean hasPromo;
    private double discount;
}
