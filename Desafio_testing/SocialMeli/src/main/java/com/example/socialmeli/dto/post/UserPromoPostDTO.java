package com.example.socialmeli.dto.post;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonPropertyOrder({"userId"})
public class UserPromoPostDTO extends PromoPostDTO
{
    @NotNull(message = "La id no puede estar vacía.")
    @Positive(message = "El id debe ser mayor a 0.")
    private Integer userId;
}
