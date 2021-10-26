package bootcamp.Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args) {

        List<Producto>  listaProductos = new ArrayList<Producto>();

        Producto prodNP1 = new NoPerecedero("Leche",25.5,"Lacteo");
        Producto prodNP2 = new NoPerecedero("Harina",15.5,"Lacteo");
        Producto prodNP3 = new NoPerecedero("Huevo",35.5,"Lacteo");
        Producto prodNP4 = new NoPerecedero("Flan",27.5,"Lacteo");
        Producto prodNP5 = new NoPerecedero("Chocolate",45.5,"Lacteo");

        Producto prodP1 = new Perecedero("Alfajor",30,3);
        Producto prodP2 = new Perecedero("Torta",40,2);
        Producto prodP3 = new Perecedero("Vainilla",50,1);
        Producto prodP4 = new Perecedero("Galletita",20,2);
        Producto prodP5 = new Perecedero("Manzana",10,3);

        listaProductos.add(prodNP1);
        listaProductos.add(prodNP2);
        listaProductos.add(prodNP3);
        listaProductos.add(prodNP4);
        listaProductos.add(prodNP5);

        listaProductos.add(prodP1);
        listaProductos.add(prodP2);
        listaProductos.add(prodP3);
        listaProductos.add(prodP4);
        listaProductos.add(prodP5);

        for (Producto p: listaProductos)
        {
            System.out.println("El producto: " + p.getNombre() + " posee un precio de: " + p.calcular(1));
        }







    }



}
