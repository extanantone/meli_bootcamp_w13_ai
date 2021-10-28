package com.company;

public class pruebaClase {
    //atributos
    String titulo;
    String autor;
    int ejemplares;

    public pruebaClase(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.ejemplares = ejemplares;
    }

    public int cantidadDeEjemplos(){
        return ejemplares;
    }

    public String mostrarLibros(){
        return "Titulo: "+ titulo + ", Autor: "+autor+", Ejemplares: "+ejemplares;
    }
}
