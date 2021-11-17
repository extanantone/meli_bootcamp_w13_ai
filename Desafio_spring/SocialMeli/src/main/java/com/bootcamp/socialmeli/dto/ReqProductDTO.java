package com.bootcamp.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ReqProductDTO extends PostDTO {

    private Long userId;

    public ReqProductDTO(Long idPost, LocalDate date, PostProductDTO detail, Integer category, Double price, Long userId) {
        super(idPost, date, detail, category, price);
        this.userId = userId;
    }

    public ReqProductDTO() {
    }
}
