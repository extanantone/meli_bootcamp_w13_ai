package com.astractasEinterfeces.Ejercicio2;

import com.c3abstractEinterfac.TipoPersona;

public class LibroPdf implements  IImprimible {

    private int cantidadDePaginas;
    private String nombreDelAutor;
    private String titulo;
    private String genero;

    public LibroPdf(int cantidadDePaginas, String nombreDelAutor, String titulo, String genero) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.nombreDelAutor = nombreDelAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimri() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "LibroPdf{" +
                "cantidadDePaginas=" + cantidadDePaginas +
                ", nombreDelAutor='" + nombreDelAutor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
