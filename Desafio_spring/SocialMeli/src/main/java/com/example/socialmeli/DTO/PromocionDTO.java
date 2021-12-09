package com.example.socialmeli.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PromocionDTO {
    private int user_id;
    private String user_name;
    private int promo_products_count;
}
