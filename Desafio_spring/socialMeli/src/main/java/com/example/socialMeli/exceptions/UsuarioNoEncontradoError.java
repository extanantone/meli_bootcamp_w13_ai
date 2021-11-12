package com.example.socialMeli.exceptions;

import com.example.socialMeli.dto.RespuestaSimpleDTO;

public class UsuarioNoEncontradoError extends Exception{
    public UsuarioNoEncontradoError(String msj) {
        super(msj);
    }
}
