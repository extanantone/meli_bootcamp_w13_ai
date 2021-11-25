package com.SocialMeli.SocialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostUserDTO extends PostDTO{
    @NotNull( message = "La id no puede estar vacía.")
    @Positive( message = "La id debe ser numérica.")
    private Integer user_id;

    @Override
    public String toString() {
        return "PostUserDTO{" +
                "user_id=" + user_id +
                '}';
    }
}
