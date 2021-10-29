package com.Meli;

import com.Meli.Entity.GuardaRopa;
import com.Meli.Entity.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Prenda campera = new Prenda("Columbia","air");
        Prenda bufanda = new Prenda("ML","internet");
        List<Prenda> lstPrenda = new ArrayList<>();
        lstPrenda.add(campera);
        lstPrenda.add(bufanda);
        GuardaRopa gr = new GuardaRopa();
        Integer nro = gr.guardarPrenda(lstPrenda);
        System.out.println("Nro de GuardaRopa: "+nro);
        gr.mostrarPrendas();
        List<Prenda> lstPrenda2 = new ArrayList<>();
        lstPrenda2 = gr.devolverPrendas(nro);
        System.out.println("Cant ropa devuelta: "+lstPrenda2.size());
        gr.mostrarPrendas();
    }
}
