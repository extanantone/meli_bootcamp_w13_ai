package com.mercadolibre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<Prenda>prendaList = new ArrayList<>();
	    Prenda prendaUno= new Prenda("Gucci","2020");
        Prenda prendaDos = new Prenda("Adidas","2021");
        GuardaRopa guardaRopa = new GuardaRopa();
        Map<Integer,List<Prenda>> miHash = new HashMap<>();
        miHash.put(10,List.of(prendaUno,prendaDos));
        guardaRopa.setGuardaRopas(miHash);
        guardaRopa.mostrarPrendas();

        System.out.println(guardaRopa.getGuardaRopas().get(10));
    }
}
