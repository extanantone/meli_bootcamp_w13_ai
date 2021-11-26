package com.example.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PromoCountDTO {

    @NotNull(message = "La id no puede estar vacía.")
    @Min(value = 1, message = "El id debe ser mayor a cero.")
    private final Integer userId;

    @Size(max = 15, message = "El nombre no puede contener más de 15 letras.")
    private final String userName;

    private final Integer promoProductsCount;

    public PromoCountDTO(Integer userId, String userName, Integer promoProductsCount) {
        this.userId = userId;
        this.userName = userName;
        this.promoProductsCount = promoProductsCount;
    }
}
