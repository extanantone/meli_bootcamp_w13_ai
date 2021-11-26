package com.bootcamp.socialmeli.dto;

import lombok.Getter;
import lombok.Setter;

import javax.servlet.annotation.HttpConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class RequestPostDTO extends PostDTO{
    @NotNull(message = "La id no puede estar vacia")
    @Positive(message = "El id debe ser mayor a cero")
    private Integer userId;

    public RequestPostDTO(Integer idPost, String date, Double price, Integer category, ProductDTO detail, Integer userId) {
        super(idPost, date, price, category, detail);
        this.userId = userId;
    }
}
