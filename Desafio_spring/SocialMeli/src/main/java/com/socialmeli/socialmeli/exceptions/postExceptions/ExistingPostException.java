package com.socialmeli.socialmeli.exceptions.postExceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExistingPostException extends RuntimeException {
    private int id;

    public ExistingPostException(int id) {
        this.id = id;
    }
}
