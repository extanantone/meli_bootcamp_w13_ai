package com.bootcamp.linktracker.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.UnknownHostException;

@ResponseStatus (reason = "URL invalida")
public class URLInvalidException extends UnknownHostException {

    public URLInvalidException(String message) {
        super(message);
    }
}
