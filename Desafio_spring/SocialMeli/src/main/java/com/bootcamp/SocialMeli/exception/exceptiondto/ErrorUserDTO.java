package com.bootcamp.SocialMeli.exception.exceptiondto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.awt.*;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorUserDTO {
    String code;
    String mensaje;
}
