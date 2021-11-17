package com.bootcamp.socialmeli.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestPostDTO extends PostDTO{
    private int userId;

    public RequestPostDTO(int idPost, String date, double price, int category, ProductDTO detail, int userId) {
        super(idPost, date, price, category, detail);
        this.userId = userId;
    }
}
