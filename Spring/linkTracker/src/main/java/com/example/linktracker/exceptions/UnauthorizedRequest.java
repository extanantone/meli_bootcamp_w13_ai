package com.example.linktracker.exceptions;

public class UnauthorizedRequest extends RuntimeException{
    public UnauthorizedRequest() {
    }

    public UnauthorizedRequest(String message) {
        super(message);
    }
}
