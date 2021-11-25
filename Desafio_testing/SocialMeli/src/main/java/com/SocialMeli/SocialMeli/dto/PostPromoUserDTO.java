package com.SocialMeli.SocialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostPromoUserDTO extends PostPromoDTO{
    @NotNull( message = "La id no puede estar vacía.")
    @Positive( message = "La id debe ser numérica.")
    private Integer user_id;
}
