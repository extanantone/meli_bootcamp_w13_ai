package com.example.SocialMeli.exception;

import org.springframework.http.HttpStatus;

public class OrderNameNotExist extends SocialMeliException {
    public OrderNameNotExist(String name) {
        super("No se puede ordernar por el nombre: "+name, HttpStatus.NOT_FOUND);
    }
}
