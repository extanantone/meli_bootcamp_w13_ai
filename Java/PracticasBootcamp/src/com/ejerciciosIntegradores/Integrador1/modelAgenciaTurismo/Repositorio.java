package com.ejerciciosIntegradores.Integrador1.modelAgenciaTurismo;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {

    List<Localizador> localizadors = new ArrayList<>();



    public List<Localizador> getLocalizadors() {
        return localizadors;
    }

    public void setLocalizadors(Localizador localizadors) {
        this.localizadors.add( localizadors);
    }
}
