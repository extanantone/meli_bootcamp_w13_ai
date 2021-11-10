package com.app.model;

import com.app.exception.TelegrafoException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Telegrafo extends Messenger{

    private boolean listen;

    public Telegrafo(){
        super();
        listen=true;
    }

    @Override
    public String menssage(String ms) {
        if(!listen)
            throw new TelegrafoException("No valid conditions for Telegrafo");
        return "Pip piripipip pip pip "+ms;
    }
}
