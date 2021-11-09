package com.c4Spring.clase5nov.excepciones;

public class NoEncontradoExcepcion extends RuntimeException{

    public NoEncontradoExcepcion(){}
    public NoEncontradoExcepcion(String mensaje){
        super(mensaje);
    }
}
