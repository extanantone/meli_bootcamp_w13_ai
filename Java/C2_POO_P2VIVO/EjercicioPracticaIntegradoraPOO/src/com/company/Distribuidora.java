package com.company;

import objetos.NoPerecedero;
import objetos.Perecedero;
import objetos.Producto;

public class Distribuidora {
    public static Producto listaProductos[] = new Producto [6];

    public static void mostrarValorCompra(){
        double resultado = 0;
        double valor = 0;
        for (Producto p : listaProductos) {
            valor = p.calcular(1);
            resultado+=valor;
            System.out.println("Producto "+p.getNombre()+ ", valor:"+valor);
        }
        System.out.println("El valor de su compra es:"+resultado);
    }

    public static void main(String[] args) {
        int i = 0;
        Producto p1 = new Producto("Pure de tomate",10.00);
        listaProductos[i] = p1;
        i++;
        NoPerecedero p2 = new NoPerecedero("Tallarines don agustin",15.00,"tipo1");
        listaProductos[i] = p2;
        i++;
        Perecedero p3 = new Perecedero("Cebolla por kg",5.00,1);
        listaProductos[i] = p3;
        i++;
        Perecedero p4 = new Perecedero("Zanahoria bolsa",10.00,2);
        listaProductos[i] = p4;
        i++;
        Perecedero p5 = new Perecedero("Ajo por cabeza",10.00,3);
        listaProductos[i] = p5;
        i++;
        Perecedero p6 = new Perecedero("Morron rojo",10.00,4);
        listaProductos[i] = p6;
        i++;

        mostrarValorCompra();
    }
}
