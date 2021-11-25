package com.bootcamp.SocialMeli.dto.publicacion;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublicacionPromoCountDTO {
    @NotNull(message = "La id no puede estar vacía.")
    @Positive(message = "El id debe ser mayor a cero.")
    private Integer userId;

    private String userName;
    private Integer promoProductsCount;
}
