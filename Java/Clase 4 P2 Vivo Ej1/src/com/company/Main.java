package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();

        List<Prenda> prendas = new ArrayList<>();
        prendas.add(new Remera("Oxygen", "Cuello en V"));
        prendas.add(new Pantalon("Taverniti", "Jean clasico"));

        List<Prenda> prendas2 = new ArrayList<>();
        prendas2.add(new Pantalon("Puma", "Short futbol"));
        prendas2.add(new Pantalon("Ardidas", "Salada master"));

        int id = guardaRopa.guardaRopa(prendas);
        int id2 = guardaRopa.guardaRopa(prendas2);
        guardaRopa.mostrarPrendas();
        System.out.println("Saque del guardarropa " + guardaRopa.devolverPrendas(id));
        guardaRopa.mostrarPrendas();
    }
}
