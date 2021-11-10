package com.app.model;

import lombok.Getter;

public abstract class Messenger {

    private static int cont;

    @Getter
    private int id;

    public Messenger(){
        id=++cont;
    }

    public abstract String menssage(String ms);


}
