package com.bootcamp.SocialMeli.DTO.Errores;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {
    String desc;
    String msg;
}
