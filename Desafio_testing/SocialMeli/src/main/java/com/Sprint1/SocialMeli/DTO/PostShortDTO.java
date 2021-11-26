package com.Sprint1.SocialMeli.DTO;

import com.Sprint1.SocialMeli.Model.Post;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostShortDTO {
    @NotNull(message = "'userId' no puede estar vacío.")
    @Positive(message = "'userId' debe ser mayor a cero.")
    private Integer userId;

    @NotNull(message = "'idPost' no puede estar vacío.")
    @Positive(message = "'idPost' debe ser mayor a cero.")
    private Integer idPost;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "'date' no puede estar vacío.")
    private LocalDate date;

    @Valid
    private ProductDTO detail;

    @NotNull(message = "'category' no puede estar vacío.")
    private Integer category;

    @NotNull(message = "'price' no puede estar vacío.")
    @Max(value=10000000, message = "'price' no puede ser mayor a 10000000")
    private Double price;

    public PostShortDTO (Post post){
        this.userId = post.getUserId();
        this.idPost = post.getIdPost();
        this.date = post.getDate();
        this.detail = new ProductDTO(post.getDetail());
        this.category = post.getCategory();
        this.price = post.getPrice();
    }
}
