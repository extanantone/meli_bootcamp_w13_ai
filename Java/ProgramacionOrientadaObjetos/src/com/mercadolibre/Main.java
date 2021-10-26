package com.mercadolibre;

import com.mercadolibre.dominio.Persona;

public class Main {
    public static void main(String[] args) {
        Persona primero = new Persona(); //Vacio
        Persona fulano = new Persona("fulanito",27,"12345678");
        Persona segundo = new Persona("fulao",29,"12345008",50,1.60);

        //Persona otro = new Persona("Nombre",12);
        System.out.println(segundo);

    }
}