package com.meli.SocialMeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostDTOResponse implements Serializable {
    @NotNull(message = "La ID del Usuario es obligatoria y no puede ser vacía.")
    @Positive(message = "La ID del Post debe ser mayor que cero.")
    private Integer userId;

    @NotNull(message = "El campo ID del Post es obligatorio y no puede ser vacío.")
    @Positive(message = "La ID del Post debe ser mayor que cero.")
    private Integer idPost;

    @NotNull(message = "date es obligatoria y no puede ser vacía.")
    //@Future(message = "date no puede ser una fecha mayor que hoy")
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;

    @NotNull(message = "El campo Date es obligatorio y no puede ser vacío.")
    @Positive(message = "La Categoría del Post debe ser mayor que cero.")
    private Integer category;

    @NotNull(message = "price es obligatorio y no puede ser vacío.")
    @Positive(message = "price debe ser mayor que cero.")
    @DecimalMax(value = "10000000.0", message = "El valor máximo de price es 10000000")
    private Double price;

    @Valid
    @NotNull(message = "detail es obligatorio.")
    private ProductDTO detail;
}