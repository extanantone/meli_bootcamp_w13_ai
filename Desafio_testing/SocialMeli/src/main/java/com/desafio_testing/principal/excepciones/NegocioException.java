package com.desafio_testing.principal.excepciones;

public class NegocioException extends RuntimeException implements ExcepcionesPersonalizadas{

    private Integer codigo;

    public NegocioException(String message, Integer codigo) {
        super(message);
        this.codigo = codigo;
    }

    @Override
    public Integer getCodigo() {
        return this.codigo;
    }

    @Override
    public String getMensaje() {
        return this.getMessage();
    }
}
