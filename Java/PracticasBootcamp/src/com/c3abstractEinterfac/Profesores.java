package com.c3abstractEinterfac;

public class Profesores implements TipoPersona{

    TipoPersona tipoPersona;

    public Profesores(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    @Override
    public String getTipoPersona() {
        return getTipoPersona()+"Profesor";
    }
}
