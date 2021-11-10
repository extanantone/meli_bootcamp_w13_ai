package com.app.model;

import com.app.exception.TelefonoException;
import lombok.Getter;
import lombok.Setter;

import java.text.ParseException;

@Getter
@Setter
public class TelefonoCelular extends  Messenger{

    private double bateria;
    private double datos;

    public TelefonoCelular(){
        super();
    }

    @Override
    public String menssage(String ms) {
        if(bateria<1 || datos<1)
            throw  new TelefonoException("No phone with valid conditions");
        bateria--;
        datos--;
        return "Enviando por WhatsApp: "+ms;
    }
}
