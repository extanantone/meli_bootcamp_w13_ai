package com.app.model;

import lombok.Getter;

public abstract class Messenger {

    private static int count;

    @Getter
    private int id;

    public Messenger(){
        id = count++;
    }


    public abstract String message(String ms);



}
