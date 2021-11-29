package com.bootcamp.SocialMeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostDTO {
    @NotNull(message = "La id no puede estar vacía.")
    @Positive(message = "El id debe ser mayor a cero.")
    Integer userId;

    @NotNull(message = "La id no puede estar vacía.")
    @Positive(message = "El id debe ser mayor a cero.")
    Integer idPost;

    @NotBlank(message = "La fecha no puede estar vacía.")
    String date;

    @Valid
    DetailDTO detail;

    @NotNull(message = "El campo no puede estar vacío.")
    Integer category;

    @NotNull(message = "El campo no puede estar vacío.")
    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
    Double price;

    public PostDTO(Integer userId, Integer idPost, String date, DetailDTO detail, Integer category, Double price) {
        this.userId = userId;
        this.idPost = idPost;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

}
