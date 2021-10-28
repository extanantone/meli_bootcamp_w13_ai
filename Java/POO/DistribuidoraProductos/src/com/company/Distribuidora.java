package com.company;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();

        productos.add(new Perecedero("Pizza", 200, 1));
        productos.add(new Perecedero("Piña", 200, 2));
        productos.add(new Perecedero("Pepino", 200, 3));
        productos.add(new Perecedero("Aceituna", 200, 4));
        productos.add(new NoPerecedero("Lentejas", 200, "sí"));

        double precioFinal = 0;
        for (Producto producto : productos) {
            double precioLocal = producto.calcular(5);
            System.out.println("Los 5 productos " + producto.getNombre() + " cuestan " + precioLocal);
            precioFinal += precioLocal;
        }
        System.out.println("El precio a pagar es: " + precioFinal);
    }
}
