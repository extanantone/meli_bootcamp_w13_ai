package com.SocialMeli.SocialMeli.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter @Setter
public class PostPromoDTORequest extends PostDTORequest {
    @NotNull
    protected Boolean has_promo;

    @NotNull
    protected Double discount;
}
