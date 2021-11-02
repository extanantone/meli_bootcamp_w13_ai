package com.mercadolibre.dominio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto>productos = new ArrayList<>();
        productosPerecederos(productos);
        productos = new ArrayList<>();
        productosNoPerecederos(productos);
    }

    private static void productosPerecederos(List<Producto> productos) {
        Perecedero perecedero;
        productos.add(new Producto("Leche",80));
        productos.add(new Producto("Queso",100));
        Scanner scanner = new Scanner(System.in);
        for (Producto producto : productos) {
            System.out.println("Ingrese los días a caducar: ");
            perecedero = new Perecedero(scanner.nextInt(),producto.getNombre(),producto.getPrecio());
            System.out.println("Ingrese la cantidad de productos: ");
            System.out.println(producto.toString() + perecedero.toString() + " total a abonar: $" + perecedero.calcular(scanner.nextInt()));
        }
    }

    private static void productosNoPerecederos(List<Producto> productos) {
        NoPerecedero noPerecedero;
        productos.add(new Producto("Yerba",150));
        productos.add(new Producto("Azucar",80));
        productos.add(new Producto("Harina",90));
        for (Producto producto:productos) {
            noPerecedero = new NoPerecedero("No perecedero");
            noPerecedero.setPrecio(producto.getPrecio());
            System.out.println(producto.toString() + noPerecedero.toString() + " total a abonar: $" + noPerecedero.calcular(20));
        }
    }

}
