package com.company;

public class SerieAlCuadrado extends SerieNumerica<Integer> {

    public SerieAlCuadrado(Integer valorInicial) {
        super.establecerValorInicial(valorInicial);
        super.setValorActual(valorInicial);
    }

    @Override
    public void obtenerValorSiguiente() {
        Integer valorActual = super.getValorActual();
        Integer nuevoValor = ((int) Math.pow(valorActual, 2));
        super.setValorActual(nuevoValor);
    }
}
