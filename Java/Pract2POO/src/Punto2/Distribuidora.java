package Punto2;

import java.util.ArrayList;

public class Distribuidora{
    public static void main(String[] args){
        ArrayList<Producto> productos = new ArrayList<>();

        NoPerecedero lataAtun = new NoPerecedero("Lata de atún",1000,"Enlatado");
        NoPerecedero lataFrijol = new NoPerecedero("Lata de frijoles",1000,"Enlatado");
        NoPerecedero lentejas = new NoPerecedero("Lentejas",1000,"Paquete");
        NoPerecedero aceite = new NoPerecedero("Aceite de oliva",1000,"Aceite");
        NoPerecedero pasta = new NoPerecedero("Pasta",1000,"Paquete");

        Perecedero manzana = new Perecedero("Manzana",1000,1);
        Perecedero pera = new Perecedero("Pera",1000,2);
        Perecedero platano = new Perecedero("Plátano",1000,3);
        Perecedero uva = new Perecedero("Uva",1000,1);
        Perecedero papaya = new Perecedero("Papaya",1000,1);

        productos.add(lataAtun);
        productos.add(lataFrijol);
        productos.add(lentejas);
        productos.add(aceite);
        productos.add(pasta);
        productos.add(manzana);
        productos.add(pera);
        productos.add(platano);
        productos.add(uva);
        productos.add(papaya);

        double valorTotal = 0;

        for(Producto p : productos){
            valorTotal += p.calcularValor(1);
        }

        System.out.println("El valor total de los productos vendidos es " + valorTotal);
    }
}
