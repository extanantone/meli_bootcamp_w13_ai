package com.company;

public abstract class SerieNumerica<T> {
    private T valorInicial;
    private T valorActual;

    public void reiniciarSerie() {
        this.valorActual = this.valorInicial;
    };

    public void establecerValorInicial(T valorInicial) {
        if (this.valorInicial != null) return;
        this.valorInicial = valorInicial;
    }

    public abstract void obtenerValorSiguiente();

    public T getValorInicial() {
        return valorInicial;
    }

    public T getValorActual() {
        return valorActual;
    }

    public void setValorActual(T valorActual) {
        this.valorActual = valorActual;
    }
}
