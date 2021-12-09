package com.bootcamp.tutorials.exception.tutorialException;

public class TutorialAlreadyExistsException extends RuntimeException{

    public TutorialAlreadyExistsException(String title) {
        super("The tutorial with title " + title + " and this same description has been created already");
    }
}
