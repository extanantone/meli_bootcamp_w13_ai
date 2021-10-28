package com.company;

public class Serie4En4 extends SerieNumerica<Double> {
    private Double valorDeSuma = 9.19;

    public Serie4En4(Double valorInicial) {
        super.establecerValorInicial(valorInicial);
        super.setValorActual(valorInicial);
    }

    @Override
    public void obtenerValorSiguiente() {
        Double valorActual = super.getValorActual();
        Double nuevoValor = valorActual + this.valorDeSuma;
        super.setValorActual(nuevoValor);
    }
}
