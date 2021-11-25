package com.SocialMeli.SocialMeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostDTO {
    @NotNull( message = "La id no puede estar vacía.")
    @Positive( message = "El id debe ser mayor a cero")
    private Integer id_post;

    @NotEmpty( message = "La fecha no puede estar vacía.")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;

    @NotNull( message = "La id no puede estar vacía.")
    private Integer category;

    @NotNull( message = "La id no puede estar vacía.")
    @Positive( message = "La id debe ser numérica.")
    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
    private Double price;
    private ProductDTO detail;
}
