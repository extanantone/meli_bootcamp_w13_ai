package com.company;

public class Informes implements Imprimible{
    String nombreAutor;
    int cantPaginas;
    String nombreRevisor;
    int longitudTexto;

    public Informes(String nombreAutor, int cantPaginas, String nombreRevisor, int longitudTexto) {
        this.nombreAutor = nombreAutor;
        this.cantPaginas = cantPaginas;
        this.nombreRevisor = nombreRevisor;
        this.longitudTexto = longitudTexto;
    }

    @Override
    public void Imprimir() {
        System.out.println("\n" + this.toString());
    }

    @Override
    public String toString() {
        return "\n >Nombre autor: \n" + nombreAutor +
                "\n >Cantidad de paginas: \n" + cantPaginas +
                "\n >Nombre revisor: \n" + nombreRevisor+
                "\n >Longitud de texto: \n" + longitudTexto;
    }
}
