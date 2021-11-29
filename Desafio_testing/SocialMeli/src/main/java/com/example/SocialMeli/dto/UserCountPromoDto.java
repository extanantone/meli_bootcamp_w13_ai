package com.example.SocialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class UserCountPromoDto {

    private int userId;
    private String userName;
    private int promoProductsCount;

}
