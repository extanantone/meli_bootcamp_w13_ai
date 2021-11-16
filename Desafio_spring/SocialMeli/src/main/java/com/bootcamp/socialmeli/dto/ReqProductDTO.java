package com.bootcamp.socialmeli.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReqProductDTO extends PostDTO {

    private Long userId;

    public ReqProductDTO(Long idPost, LocalDate date, PostProductDTO detail, Integer category, Double price, Long userId) {
        super(idPost, date, detail, category, price);
        this.userId = userId;
    }

    public ReqProductDTO() {
    }
}
