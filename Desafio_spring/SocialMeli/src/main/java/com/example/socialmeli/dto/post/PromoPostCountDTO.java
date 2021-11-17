package com.example.socialmeli.dto.post;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PromoPostCountDTO
{
    private int userId;
    private String userName;
    private int promoProductsCount;
}
