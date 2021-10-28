package com.company;

public abstract class Prototipo<T> {
    private T valorSerie;

    public Prototipo(T valorSerie) {
        this.valorSerie = valorSerie;
    }

    public T getValorSerie() {
        return valorSerie;
    }

    public void setValorSerie(T valorSerie) {
        this.valorSerie = valorSerie;
    }
}
