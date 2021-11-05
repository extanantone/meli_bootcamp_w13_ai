package com.blog.exception;

public class ExistException extends RuntimeException{

    public static String EXISTRESOURCE = "Ya existe un recurso con el id ingresado";

    public ExistException(String msg){
        super(msg);
    }
}
