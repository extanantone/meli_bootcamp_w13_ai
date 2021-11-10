package com.app.model;

public class Telegrafo extends Messenger{

    public Telegrafo(){
        super();
    }

    @Override
    public String message(String ms) {
        return "Pip piripipip pip pip "+ms;
    }
}
