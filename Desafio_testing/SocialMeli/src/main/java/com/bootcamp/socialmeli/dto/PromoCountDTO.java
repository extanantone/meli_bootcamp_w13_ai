package com.bootcamp.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromoCountDTO {
    @JsonProperty("user_id")
    private Long userID;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("promo_products_count")
    private Long promoProductsCount;
}
