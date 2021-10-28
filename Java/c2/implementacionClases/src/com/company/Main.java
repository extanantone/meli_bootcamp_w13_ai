package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Libro libro = new Libro("Harry Potter", "JKR", 20);
        System.out.println(libro.mostrarLibro());
        System.out.println("la cantidad de ejemplares para este libro es de : " + libro.cantidadDeEjemplares());
    }
}
