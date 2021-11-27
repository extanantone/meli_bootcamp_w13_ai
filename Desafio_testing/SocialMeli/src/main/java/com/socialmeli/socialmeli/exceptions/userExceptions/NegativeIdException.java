package com.socialmeli.socialmeli.exceptions.userExceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NegativeIdException extends RuntimeException{
    private int id;

    public NegativeIdException(int id) {
        this.id = id;
    }
}
