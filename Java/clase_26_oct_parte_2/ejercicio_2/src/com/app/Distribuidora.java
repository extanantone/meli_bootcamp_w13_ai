package com.app;

public class Distribuidora {

public static void main(String[] args) {
    Producto[] productos = {
        new Producto("Gallletas",1.9),
        new Perecedero("Pan", 3.5, 2),
        new NoPerecedero("Agua",12.8,"Bebida")
        
    };
    int total =0;
    for(Producto p: productos){
        total+=p.calcular(5);
        System.out.println("Item comprado: \n"+p.toString());
        System.out.println("\n\n Precio por 5 elementos: "+p.calcular(5));
        System.out.println();
    }
    System.out.println("Precio total: "+total);
}
    
}
