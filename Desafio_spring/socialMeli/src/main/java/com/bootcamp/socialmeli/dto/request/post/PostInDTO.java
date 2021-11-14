package com.bootcamp.socialmeli.dto.request.post;

import com.bootcamp.socialmeli.entitiy.Product;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostInDTO {

    private int userId;
    private int IdPost;
    private String date;
    private ProductInDTO detail;
    private int category;
    private double price;

}
