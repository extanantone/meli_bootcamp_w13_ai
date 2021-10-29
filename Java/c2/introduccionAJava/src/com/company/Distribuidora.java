package com.company;

public class Distribuidora {
    public static void main(String[] args) {

        // EJERCICIO 2
        Producto[] productos = {new Producto("cafe", 10), new Perecedero("queso", 20, 2), new NoPerecedero("arroz", 30, "alimento")};

        double precioVenta = 0;
        for (Producto p : productos) {
            precioVenta += p.calcular(5);
        }
        System.out.println("El precio total de la venta es de $" + precioVenta);
    }
}
