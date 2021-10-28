package com.company;

public class Main {

    public static void main(String[] args) {
        SerieNumerica<Double> serie4En4 = new Serie4En4(33.1);

        System.out.println(serie4En4.getValorActual());

        serie4En4.obtenerValorSiguiente();
        serie4En4.obtenerValorSiguiente();

        System.out.println(serie4En4.getValorActual());

        serie4En4.reiniciarSerie();

        System.out.println(serie4En4.getValorActual());

        SerieNumerica<Integer> serieAlCuadrado = new SerieAlCuadrado(4);

        System.out.println(serieAlCuadrado.getValorActual());

        serieAlCuadrado.obtenerValorSiguiente();
        serieAlCuadrado.obtenerValorSiguiente();

        System.out.println(serieAlCuadrado.getValorActual());

        serieAlCuadrado.reiniciarSerie();

        System.out.println(serieAlCuadrado.getValorActual());

        


    }
}
