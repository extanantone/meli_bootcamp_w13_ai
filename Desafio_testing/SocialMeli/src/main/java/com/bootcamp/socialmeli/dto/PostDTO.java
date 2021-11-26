package com.bootcamp.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostDTO {
    @NotNull(message = "La id no puede estar vacía")
    @Positive(message = "El id debe ser mayor a cero")
    private Integer idPost;
    @NotNull(message = "La fecha no puede estar vacia")
    @Pattern(regexp = "^[0-9]{2}-[0-9]{2}-[0-9]{4}$", message = "La fecha debe tener el formato dd-MM-yyyy (ej: 12-01-1999)")
    private String date;
    @NotNull(message = "El campo no puede estar vacío")
    @Range(min = 0, max = 10000000, message = "El precio máximo por producto es de 10.000.000")
    private Double price;
    @NotNull(message = "El campo no puede estar vacio")
    private Integer category;
    private @Valid ProductDTO detail;
}
