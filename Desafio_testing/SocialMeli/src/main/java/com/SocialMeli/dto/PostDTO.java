package com.SocialMeli.dto;

import com.SocialMeli.model.Post;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostDTO {
    @NotNull(message = "La id no puede estar vacía")
    @Positive(message = "El id debe ser mayor a cero")
    private Integer userId;

    @NotNull(message = "La id no puede estar vacía.")
    @Positive(message = "El id debe ser mayor a cero")
    private Integer idPost;

    @NotNull(message = "La fecha no puede estar vacía.")
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;

    @Valid
    private ProductDetailDTO detail;

    @NotNull(message = "El campo no puede estar vacío.")
    private Integer category;

    @NotNull(message = "El campo no puede estar vacío.")
    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
    @Positive(message = "El precio debe ser mayor a cero")
    private Double price;


    public PostDTO(Integer userId, Integer idPost, String date, ProductDetailDTO detail, Integer category, Double price) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        this.userId = userId;
        this.idPost = idPost;
        this.date =  LocalDate.parse(date, formatter);
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

    public PostDTO(Post post) {
        this.userId = post.getUserId();
        this.idPost = post.getIdPost();
        this.date =  post.getDate();
        this.detail = new ProductDetailDTO(post.getDetail());
        this.category = post.getCategory();
        this.price = post.getPrice();
    }
}
