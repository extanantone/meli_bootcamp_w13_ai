package poo.p2;

import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {

        ArrayList<Producto> productos = new ArrayList<>();

        productos.add(new Producto("Leche",2200));


        Producto producto1 = new Perecedero("Leche", 222,1);
        Producto producto2 = new Perecedero("Carne", 343,2);
        Producto producto3 = new Perecedero("Pescado", 435,3);
        Producto producto4 = new Perecedero("Queso", 522,1);
        Producto producto5 = new Perecedero("Yogurt", 222,3);

        Producto noPerecedero1 = new NoPerecedero("Detergente",334,"Limpieza");
        Producto noPerecedero2 = new NoPerecedero("Arroz",533,"Almacén");
        Producto noPerecedero3 = new NoPerecedero("Chocolate",766,"Almacén");
        Producto noPerecedero4 = new NoPerecedero("Pasta",675,"Almacén");
        Producto noPerecedero5 = new NoPerecedero("Sal",988,"Almacén");

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);

        productos.add(noPerecedero1);
        productos.add(noPerecedero2);
        productos.add(noPerecedero3);
        productos.add(noPerecedero4);
        productos.add(noPerecedero5);


        for (Producto producto : productos){
            System.out.println(producto.calcular(5));
        }

    }
}
