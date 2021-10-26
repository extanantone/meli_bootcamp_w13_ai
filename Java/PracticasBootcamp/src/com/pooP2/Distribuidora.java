package com.pooP2;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<>();

        productos.add(new NoPerecedero("Horno",350000,"ElectroDomestico"));
        productos.add(new NoPerecedero("Lavadora",1500000,"ElectroDomestico"));
        productos.add(new NoPerecedero("Secadora",1500000,"ElectroDomestico"));
        productos.add(new NoPerecedero("Sofa",2600000,"Hogar"));
        productos.add(new NoPerecedero("Silla",150000,"Hogar"));
        productos.add(new Perecedero("Yogurt",1500,1));
        productos.add(new Perecedero("Leche",1500,3));
        productos.add(new Perecedero("Pan",3500,5));
        productos.add(new Perecedero("Cafe",11500,3));
        productos.add(new Perecedero("Torta",13500,3));

        productos.get(0).calcular(2);
        productos.get(5).calcular(1);
        productos.get(6).calcular(1);
        productos.get(7).calcular(1);
        productos.get(8).calcular(1);
        productos.get(9).calcular(1);

        double sumaProductosNoPerecederos = productos.stream().filter(producto -> producto.getClass() == NoPerecedero.class ).mapToDouble(Producto::getPrecio).sum();
        double sumaProductosPerecederos = productos.stream().filter(producto -> producto.getClass() == Perecedero.class ).mapToDouble(Producto::getPrecio).sum();

        System.out.println("=========Productos No Perecederos===========");
        productos.stream().filter(producto -> producto.getClass() == NoPerecedero.class ).forEach(producto -> System.out.println(producto.toString()));
        System.out.println("\n");
        System.out.println("=========Productos Perecederos===========");
        productos.stream().filter(producto -> producto.getClass() == Perecedero.class ).forEach(producto -> System.out.println(producto.toString()));
        System.out.println("\n");
        System.out.println("=========Suma Total por Tipo===========");
        System.out.println("Suma de Productos No Perecederos = " +sumaProductosNoPerecederos);
        System.out.println("Suma de Productos Perecederos =" +sumaProductosPerecederos);

    }
}
