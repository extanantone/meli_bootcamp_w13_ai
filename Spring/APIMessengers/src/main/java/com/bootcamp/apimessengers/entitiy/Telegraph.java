package com.bootcamp.apimessengers.entitiy;

public class Telegraph implements Messenger{

    private String TYPE;

    public Telegraph() {
        this.TYPE = "Telegrafo";
    }

    @Override
    public String showMessage(String message) {
        return String.format("Pip piripipip pip pip <<%s>>",message);
    }

    @Override
    public String getType() {
        return this.TYPE;
    }
}
