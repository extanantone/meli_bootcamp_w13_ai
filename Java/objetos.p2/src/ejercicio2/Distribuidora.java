package ejercicio2;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Distribuidora {

    public static ArrayList<Producto> inicializarArrays() {
        Producto p1 = new Perecedero("Perecedero 1", 15, 6);
        Producto p2 = new Perecedero("Perecedero 2", 54, 1);
        Producto p3 = new Perecedero("Perecedero 3", 3, 2);
        Producto p4 = new Perecedero("Perecedero 4", 1, 6);
        Producto p5 = new Perecedero("Perecedero 5", 3, 10);

        //Inicializo los productos No Perecedero.
        Producto np1 = new NoPerecedero("No Perecedero 1", 15);
        Producto np2 = new NoPerecedero("No Perecedero 2", 54);
        Producto np3 = new NoPerecedero("No Perecedero 3", 3);
        Producto np4 = new NoPerecedero("No Perecedero 4", 1);
        Producto np5 = new NoPerecedero("No Perecedero 5", 3);

        ArrayList<Producto> productos = new ArrayList<>();
        //Agrego los productos perecederos.
        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);
        productos.add(p5);

        //Agrego los productos no perecederos
        productos.add(np1);
        productos.add(np2);
        productos.add(np3);
        productos.add(np4);
        productos.add(np5);
        return productos;
    }

    public static void main(String[] args) {
        ArrayList<Producto> prods = Distribuidora.inicializarArrays();
        double precioTotal = 0;
        for (Producto prod : prods) {
            precioTotal = precioTotal + prod.calcular(5);
        }
        System.out.println("Precio total de la venta fue de: "+precioTotal);

    }
}
