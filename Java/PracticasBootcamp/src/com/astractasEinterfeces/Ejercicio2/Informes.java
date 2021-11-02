package com.astractasEinterfeces.Ejercicio2;

public class Informes implements IImprimible {

    private String texto;
    private int cantidadPagina;
    private String Auntor;
    private String  revisor;

    public Informes(String texto, int cantidadPagina, String auntor, String revisor) {
        this.texto = texto;
        this.cantidadPagina = cantidadPagina;
        Auntor = auntor;
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Informes{" +
                "texto='" + texto + '\'' +
                ", cantidadPagina=" + cantidadPagina +
                ", Auntor='" + Auntor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }

    @Override
    public void imprimri() {
        System.out.println( toString());
    }
}
