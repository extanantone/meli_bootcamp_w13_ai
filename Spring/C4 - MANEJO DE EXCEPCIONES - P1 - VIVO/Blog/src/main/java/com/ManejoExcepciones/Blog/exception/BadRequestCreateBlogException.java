package com.ManejoExcepciones.Blog.exception;

public class BadRequestCreateBlogException extends RuntimeException{
    public BadRequestCreateBlogException() {}

    public BadRequestCreateBlogException(String message) { super(message); }
}
