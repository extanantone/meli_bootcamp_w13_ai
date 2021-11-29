package com.example.socialmeli.exceptions;

public class ActionPrevioslyComplete  extends RuntimeException{
    public ActionPrevioslyComplete(String message) {
        super(message);
    }

    public ActionPrevioslyComplete() {
    }
}
