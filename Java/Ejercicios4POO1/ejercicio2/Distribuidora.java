package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<>();

        productos.add(new Perecedero("Leche",12,1));
        productos.add(new NoPerecedero("Miel",10,"Soy no perecedero"));
        productos.add(new Perecedero("Queso",10,2));
        productos.add(new NoPerecedero("Arroz",10,"Soy no perecedero 2"));
        productos.add(new Perecedero("Yogurt",9,3));
        productos.add(new Perecedero("Galletas",15,30));

        for (Producto p: productos) {
            System.out.println(p);
            System.out.println("Costo 5 productos: " + p.calcular(5));
        }

    }

}
