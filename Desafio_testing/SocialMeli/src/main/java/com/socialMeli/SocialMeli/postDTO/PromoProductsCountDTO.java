package com.socialMeli.SocialMeli.postDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PromoProductsCountDTO {
    private Integer user_id;
    private String user_name;
    private Integer promo_products_count;

    public PromoProductsCountDTO(Integer user_id, String user_name, Integer promo_products_count) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.promo_products_count = promo_products_count;
    }
}
