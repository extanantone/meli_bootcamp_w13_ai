package com.app.model;

import com.app.exception.PalomaException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Paloma extends Messenger{

    private int comida;

    private int tiempoDescanzo;

    public Paloma(){
        super();
    }

    @Override
    public String menssage(String ms) {
        if(comida<1 || tiempoDescanzo<1)
            throw new PalomaException("No valid paloma contions");
        comida--;
        tiempoDescanzo=0;
        return "Grru Rru Gu (Me agarran a mi patita un papelito) "+ms;
    }

}
