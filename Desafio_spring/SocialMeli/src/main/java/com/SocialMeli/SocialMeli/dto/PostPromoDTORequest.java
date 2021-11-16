package com.SocialMeli.SocialMeli.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PostPromoDTORequest extends PostDTORequest {
    protected boolean has_promo;
    protected double discount;
}
