package com.company.aylu;

import com.company.aylu.ejercicio2.Distribuidora;
import com.company.aylu.ejercicio2.NoPerecedero;
import com.company.aylu.ejercicio2.Perecedero;
import com.company.aylu.ejercicio2.Producto;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Producto p1 = new Perecedero("carne",500,3);
        Producto p2 = new Perecedero("pollo",300,1);
        Producto p3 = new Perecedero("salmon",1000,2);
        Producto p4 = new NoPerecedero("arroz",60);
        Producto p5 = new NoPerecedero("fideos",80);
        Producto p6 = new NoPerecedero("jugo",20);

        List<Producto> listaProductos = new ArrayList<>();
        listaProductos.add(p1);
        listaProductos.add(p2);
        listaProductos.add(p3);
        listaProductos.add(p4);
        listaProductos.add(p5);
        listaProductos.add(p6);

        Distribuidora distribuidora = new Distribuidora(listaProductos);

        for(Producto producto:listaProductos){
            System.out.println(producto.toString()) ;
        }


    }
}
