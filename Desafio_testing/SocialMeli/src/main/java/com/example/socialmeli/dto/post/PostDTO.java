package com.example.socialmeli.dto.post;

import com.example.socialmeli.dto.product.ProductDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostDTO
{
    @NotNull(message = "La id no puede estar vacía.")
    @Positive(message = "El id debe ser mayor a 0.")
    private Integer idPost;

    @NotNull(message = "La fecha no puede estar vacía.")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    @Valid
    private ProductDTO detail;

    @NotNull(message = "El campo no puede estar vacío.")
    private Integer category;

    @NotNull(message = "El campo no puede estar vacío.")
    @Max(value = 10_000_000, message = "El precio máximo puede ser 10.000.000.")
    private Double price;
}
