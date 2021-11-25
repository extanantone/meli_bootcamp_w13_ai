package com.meli.SocialMeli.exception;

import lombok.Data;

@Data
public class BadRequestException extends RuntimeException {
    private String mensaje;
    public BadRequestException(String mensaje){
        this.mensaje = mensaje;
    }
}
