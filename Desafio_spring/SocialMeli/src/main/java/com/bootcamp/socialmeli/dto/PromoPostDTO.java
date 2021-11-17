package com.bootcamp.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PromoPostDTO {

    private long postId;
    private String date;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;

    private long userId;
    private ProductDTO detail;

    public boolean hasPromo() {
        return hasPromo;
    }
}
