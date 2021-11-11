package com.bootcamp.apimessengers.entitiy;

public class Pigeon implements Messenger{

    private final String TYPE;

    public Pigeon() {
        this.TYPE = "Paloma";
    }

    @Override
    public String showMessage(String message) {
        String response = String.format("Grru Rru Gu (Me agarran a mi patita un papelito) <<%s>>",message);
        return response;
    }

    @Override
    public String getType() {
        return this.TYPE;
    }
}
