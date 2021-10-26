package PM.Ejercicio2;

import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();

        Producto perecedero1 = new Perecedero("Leche", 120.50, 1);
        Producto perecedero2 = new Perecedero("Manteca", 154.60, 3);
        Producto perecedero3 = new Perecedero("Queso", 450.90, 2);
        Producto perecedero4 = new Perecedero("Yogur", 130.40, 1);
        Producto perecedero5 = new Perecedero("Pescado", 220.80, 3);

        Producto noPerecedero1 = new NoPerecedero("Detergente", 98.60, "Limpieza");
        Producto noPerecedero2 = new NoPerecedero("Arroz", 115.40, "Almacén");
        Producto noPerecedero3 = new NoPerecedero("Fideos", 48.20, "Almacén");
        Producto noPerecedero4 = new NoPerecedero("Chocolate", 125.90, "Golosina");
        Producto noPerecedero5 = new NoPerecedero("Sal", 57.60, "Almacén");

        productos.add(perecedero1);
        productos.add(perecedero2);
        productos.add(perecedero3);
        productos.add(perecedero4);
        productos.add(perecedero5);
        productos.add(noPerecedero1);
        productos.add(noPerecedero2);
        productos.add(noPerecedero3);
        productos.add(noPerecedero4);
        productos.add(noPerecedero5);

        for (Producto producto : productos) {
            System.out.println(producto.calcular(5));
        }
    }
}