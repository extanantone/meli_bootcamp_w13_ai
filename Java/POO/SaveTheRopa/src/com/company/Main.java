package com.company;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Prenda> prendas = new ArrayList<>();

        prendas.add(new Prenda("pizza", "dos"));
        prendas.add(new Prenda("pepperoni", "si"));

        GuardaRopa guardaRopa = new GuardaRopa();

        Integer llave = guardaRopa.guardarPrendas(prendas);

        System.out.println("La llave para su ropa es: " + llave);

        guardaRopa.mostrarPrendas();

        List<Prenda> prendasDevueltas = guardaRopa.devolverPrendas(llave);

        for(Prenda prenda : prendasDevueltas) {
            System.out.println(prenda.getMarca() + " - " + prenda.getModelo());
        }
    }
}
