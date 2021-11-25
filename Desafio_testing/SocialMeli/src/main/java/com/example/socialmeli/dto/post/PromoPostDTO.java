package com.example.socialmeli.dto.post;

import com.example.socialmeli.dto.product.ProductDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PromoPostDTO extends PostDTO
{
    @NotNull(message = "El campo no puede estar vacío.")
    private boolean hasPromo;

    @Max(value = 10_000_000, message = "El precio máximo puede ser 10.000.000.")
    private double discount;
}
