package com.example.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostListDTO {

    @NotNull(message = "La id no puede estar vacía.")
    @Min(value = 1, message = "El id debe ser mayor a cero.")
    private final Integer idPost;

    @NotNull(message = "La fecha no puede estar vacía.")
    private final String date;

    private final ProductDetailDTO detail;

    @NotNull
    private final Integer category;

    @NotNull
    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
    private final Double price;

    public PostListDTO(Integer idPost, LocalDate date, ProductDetailDTO detail, Integer category, Double price) {
        this.idPost = idPost;
        this.date = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.detail = detail;
        this.category = category;
        this.price = price;
    }
}
