package com.company;

import com.company.models.GuardaRopa;
import com.company.models.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Prenda pantalón = new Prenda("Genérica", "Nuevo");
        Prenda camisa = new Prenda("Top", "2023");

        List<Prenda> ropa = new ArrayList();
        List<Prenda> ropa2 = new ArrayList();

        ropa.add(pantalón);
        ropa.add(camisa);

        GuardaRopa guardaRopa = new GuardaRopa();

        Integer ticket = guardaRopa.guardarPrendas(ropa);
        //obtenemos la key

        guardaRopa.mostrarPrendas();

        guardaRopa.devolverPrendas(ticket);
        //nos devuelven las prendas

        guardaRopa.mostrarPrendas();



    }

}
