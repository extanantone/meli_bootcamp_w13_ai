package com.bootcamp.tutorials.exception.tutorialException;

public class TutorialNotPublishedException extends RuntimeException{

    public TutorialNotPublishedException(Long id) {
        super("The tutorial with id " + id + " has not been published yet.");
    }
}
