package com.bootcamp.tutorials.exception.tutorialException;

public class NotFoundTutorialException extends RuntimeException{

    public NotFoundTutorialException(Long id) {
        super("The tutorial with id " + id + " has not been found.");
    }
}
