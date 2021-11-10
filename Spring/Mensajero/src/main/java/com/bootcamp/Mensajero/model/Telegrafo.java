package com.bootcamp.Mensajero.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Telegrafo extends MensajeroAbstracto {
    private boolean enchufado;
    public Telegrafo(String tipo) {
        super("Piripi <<",tipo);
    }


}
