package com.example.socialMeli.exceptions;

import com.example.socialMeli.dto.RespuestaSimpleDTO;

public class UsuarioNoEncontradoError extends RuntimeException{
    public UsuarioNoEncontradoError(String message) {
        super(message);
        RespuestaSimpleDTO rta = new RespuestaSimpleDTO(message, 400);
    }
}
