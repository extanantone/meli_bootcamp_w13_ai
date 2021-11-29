package com.socialmeli.demo.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PromocionDTO {

    @NotNull(message = "Debe introducir un id de producto")
    @Positive(message="El valor minimo es 1")

    private Integer user_id;
    private String user_name;
    private Integer promo_products_count;
}
