package com.mercadolibre.dominio;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto>productos = new ArrayList<>();
        cargarProductos(productos);
    }

    private static void cargarProductos(List<Producto> productos) {
        Producto uno= new Producto("Leche",80);
        Producto cinco = new Producto("Queso",100);
        Producto dos = new Producto("Yerba",150);
        Producto tres = new Producto("Azucar",80);
        Producto cuatro = new Producto("Harina",90);

    }
}
