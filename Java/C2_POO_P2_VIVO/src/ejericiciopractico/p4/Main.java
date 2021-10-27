package ejericiciopractico.p4;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<>();

        Producto leche = new Perecedero("leche",1.5,5);
        Producto carne = new Perecedero("Carne",3.2,1);
        Producto huevos = new Perecedero("Huevos",0.6,5);
        Producto papel = new NoPerecedero("Papel",10,"Baño");
        Producto toallas = new NoPerecedero("Toallas",23.2,"Cocina");

        productos.add(leche);
        productos.add(carne);
        productos.add(huevos);
        productos.add(papel);
        productos.add(toallas);

        int cantidadVendidos = 5;
        double precioAcumulado = 0.0;
        for(Producto elementos:productos)
        {
            double precioCalculado = elementos.calcular(cantidadVendidos);
            System.out.println("el precio de vender " + cantidadVendidos + " de "
                    + elementos.getNombre() +" es: " + precioCalculado);
            precioAcumulado = precioAcumulado+precioCalculado;
        }
        System.out.println("el total de todo lo vendido es: " + precioAcumulado);

    }
}
