package com.bootcamp.apimessengers.entitiy;

public class Phone implements Messenger{

    private final String TYPE;

    public Phone() {
        this.TYPE="Phone";
    }

    @Override
    public String showMessage(String message) {
        return String.format("Enviando por WhatsApp <<%s>>",message);
    }

    @Override
    public String getType() {
        return this.TYPE;
    }
}
