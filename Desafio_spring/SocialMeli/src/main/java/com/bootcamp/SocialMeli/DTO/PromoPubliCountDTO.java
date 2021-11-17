package com.bootcamp.SocialMeli.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PromoPubliCountDTO {
    private Integer userId;
    private String userName;
    private Integer promoProductsCount;
}
