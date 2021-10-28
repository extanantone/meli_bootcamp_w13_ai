package com.company;

public class Main {

    public static void main(String[] args) {
        SerieEstandar<Float> serie = new Serie3<>();
        serie.setValorInicial(2.f);
        for (int i = 0; i < 4; i++) {
            System.out.println(serie.devolverSiguienteValor());
        }
        serie.setValorInicial(1.f);
        serie.reiniciarSerie();
        for (int i = 0; i < 2; i++) {
            System.out.println(serie.devolverSiguienteValor());
        }
    }
}
