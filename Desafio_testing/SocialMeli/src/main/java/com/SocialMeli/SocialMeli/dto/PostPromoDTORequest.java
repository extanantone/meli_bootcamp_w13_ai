package com.SocialMeli.SocialMeli.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter @Setter
public class PostPromoDTORequest extends PostDTORequest {
    @NotNull(message = "El campo no puede ser nulo")
    protected Boolean has_promo;

    @NotNull(message = "El campo no puede ser nulo")
    protected Double discount;
}
