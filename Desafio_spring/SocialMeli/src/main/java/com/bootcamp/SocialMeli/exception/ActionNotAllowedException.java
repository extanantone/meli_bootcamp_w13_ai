package com.bootcamp.SocialMeli.exception;

public class ActionNotAllowedException extends RuntimeException {
    public ActionNotAllowedException(String message) {
        super("Action not allowed: " + message);
    }
}
