package com.meli.SocialMeli.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BadRequestException extends RuntimeException {
    private String mensaje;
    public BadRequestException(String mensaje){
        this.mensaje = mensaje;
    }
}
