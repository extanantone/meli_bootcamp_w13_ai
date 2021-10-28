package com.company;

public abstract class Prototipo {
    private Integer numero;

    public Prototipo(Integer numero) {
        this.numero = numero;
    }

    public Integer getNumero() {
        return numero;
    }

    public Integer setNumero(Integer numero) {
        this.numero = numero;
        return numero;
    }

    abstract Integer numSiguiente();

    abstract Integer rinSerie();

    abstract Integer valInicial();

    @Override
    public String toString() {
        return "Prototipo{" +
                "numero=" + numero +
                '}';
    }
}
