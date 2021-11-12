package com.desafio_spring.principal.excepciones;

public class NegocioException extends RuntimeException{
    private Integer codigo;

    public NegocioException(String message, Integer codigo) {
        super(message);
        this.codigo = codigo;
    }
}
