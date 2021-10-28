package com.company;

import models.GuardarRopa;
import models.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        GuardarRopa g = new GuardarRopa();
	    Prenda p = new Prenda("Nike","Air");
        List<Prenda> listaPrendas = new ArrayList<>();
        listaPrendas.add(p);
	    p = new Prenda("Adidas","Force");
        listaPrendas.add(p);
        g.guardarPrendas(listaPrendas);
	    p = new Prenda("Kappa","Remera");
        listaPrendas.add(p);
        listaPrendas.add(p);
        g.guardarPrendas(listaPrendas);
        g.mostrarPrendas();
        g.devolverPrendas(1);
        System.out.println("-----------");
        g.mostrarPrendas();

    }
}
