package com.company;

public class LibroPdf implements Imprimible{
    String nombreAutor;
    int cantPaginas;
    String titulo;
    String genero;

    public LibroPdf(String nombreAutor, int cantPaginas, String titulo, String genero) {
        this.nombreAutor = nombreAutor;
        this.cantPaginas = cantPaginas;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void Imprimir() {
        System.out.println("\n" + this.toString());
    }

    @Override
    public String toString() {
        return "\n >Nombre autor: \n" + nombreAutor +
                "\n >Cantidad de paginas: \n" + cantPaginas +
                "\n >Titulo: \n" + titulo +
                "\n >Genero: \n" + genero ;
    }
}
