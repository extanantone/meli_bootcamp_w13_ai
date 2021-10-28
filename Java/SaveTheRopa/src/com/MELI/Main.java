package com.MELI;

import com.MELI.models.GuardaRopa;
import com.MELI.models.Prenda;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Prenda buzo = new Prenda("Lolla", "Palooza");
        Prenda remera = new Prenda("Vogue", "DG");


        //Guardamos las prendas en el guardarropa
        GuardaRopa guardaRopa1 = new GuardaRopa();
        Integer numero = guardaRopa1.guardarPrendas(List.of(buzo, remera));


        //Imprimimos las prendas
        guardaRopa1.mostrarPrendas();

        //Devolvemos la ropa
        System.out.println(guardaRopa1.devolverPrendas(numero));

    }
}
