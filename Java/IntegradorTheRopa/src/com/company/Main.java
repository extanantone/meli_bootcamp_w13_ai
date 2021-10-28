package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();

        Prenda prenda = new Prenda("Nike", "Air Force");
        Prenda prenda1 = new Prenda("Adidas", "One");

        List<Prenda> prendas = Arrays.asList(prenda,prenda1);

        Integer idPreG = guardaRopa.guardaPrendas(prendas);

        guardaRopa.mostrarPrenda();

        List<Prenda> prendas1 = guardaRopa.devolverPrendas(idPreG);
        guardaRopa.mostrarPrenda();

        System.out.println("Dato diccionario: "+guardaRopa.getDic());
    }
}
