package com.sprint.SocialMeli.dto.out;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public class PromoPostCountDto {
    int user_id;
    String user_name;
    int promo_products_count;
}
