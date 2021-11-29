package com.example.socialmeli.exceptions;

public class ActionRedundant extends RuntimeException {
    public ActionRedundant() {
    }

    public ActionRedundant(String message) {
        super(message);
    }
}
