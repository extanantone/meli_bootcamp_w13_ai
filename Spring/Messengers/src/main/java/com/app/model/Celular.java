package com.app.model;

public class Celular extends Messenger {

    public Celular(){
        super();
    }

    @Override
    public String message(String ms) {
        return "Enviando por WhatsApp "+ms;
    }
}
