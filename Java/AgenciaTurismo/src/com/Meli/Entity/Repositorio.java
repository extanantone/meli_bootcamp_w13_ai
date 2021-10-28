package com.Meli.Entity;

import java.util.ArrayList;
import java.util.List;

public abstract class Repositorio <T>{
    protected List<T> elementos;

    public Repositorio() {
        this.elementos = new ArrayList<>();
    }

    public Repositorio(List<T> elementos) {
        this.elementos = elementos;
    }

    public abstract void add(T elementos);

    public List<T> getElementos() {
        return elementos;
    }

    public void setElementos(List<T> elementos) {
        this.elementos = elementos;
    }


}
