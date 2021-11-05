package com.blog.exception;

public class NotFoundEntryException extends RuntimeException{

    public static String NOEXISTRESOURCE = "No existe el recurso solicitado";

    public  NotFoundEntryException(String msg){
        super(msg);
    }
}
