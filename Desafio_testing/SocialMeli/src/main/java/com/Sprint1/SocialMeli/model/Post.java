package com.Sprint1.SocialMeli.model;



import com.Sprint1.SocialMeli.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import java.time.LocalDate;


@Data
@NoArgsConstructor @AllArgsConstructor

public class Post {
    @Valid


    @NotNull(message = "La id USER_ID no puede estar vacía.")
    @Positive(message = "La id USER_ID debe ser mayor a cero.")
    private Integer user_id;

    @NotNull(message = "La id ID_POST no puede estar vacía.")
    @Positive(message = "La id ID_POST debe ser mayor a cero.")
    private Integer id_post;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "La FECHA no puede estar vacía.")
    private LocalDate date;

    @Valid
    private ProductDTO detail;

    @NotNull(message = "El campo CATEGORY no puede estar vacío.")
    private Integer category;

    @NotNull(message = "El campo PRICE no puede estar vacío.")
    @Max(value = 10000000, message = "El campo PRICE deber ser menor o igual a 10000000")
    private Double price;

    @Override
    public String toString() {
        return "Post{" +
                "user_id=" + user_id +
                ", id_post=" + id_post +
                ", date=" + date +
                ", detail=" + detail +
                ", category=" + category +
                ", price=" + price +
                '}';
    }
}
