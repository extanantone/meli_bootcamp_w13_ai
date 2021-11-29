package com.example.socialmeli.exceptions;

public class OrderNoFound extends RuntimeException{
    public OrderNoFound() {
    }

    public OrderNoFound(String message) {
        super(message);
    }
}
