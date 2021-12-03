package com.meli.probandojpa.exceptio;

public class UserDuplicateException extends RuntimeException  {

    public UserDuplicateException(Long id) {
        super("Ya  existe el estudiante " + id);
    }

}
