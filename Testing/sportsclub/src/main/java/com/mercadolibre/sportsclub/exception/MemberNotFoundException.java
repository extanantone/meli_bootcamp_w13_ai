package com.mercadolibre.sportsclub.exception;

import org.springframework.http.HttpStatus;

public class MemberNotFoundException extends SportClubException {

    public MemberNotFoundException(Long id) {
        super("The member with Id: " + id + " was not found.", HttpStatus.NOT_FOUND);
    }
}
