package com.bootcamp.socialmeli.exception;

import javax.management.RuntimeMBeanException;

public class IllegalRequestParamException extends RuntimeException {
    public IllegalRequestParamException() {
    }

    public IllegalRequestParamException(String message) {
        super(message);
    }
}
