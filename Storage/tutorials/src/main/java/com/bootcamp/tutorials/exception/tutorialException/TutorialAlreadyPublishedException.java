package com.bootcamp.tutorials.exception.tutorialException;

public class TutorialAlreadyPublishedException extends RuntimeException{

    public TutorialAlreadyPublishedException(Long id) {
        super("The tutorial with id " + id + " has been published already.");
    }
}
